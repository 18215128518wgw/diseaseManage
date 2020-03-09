package cn.itcast.user.controller;

import cn.itcast.user.pojo.Student;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.StudentService;
import cn.itcast.user.service.UserService;
import cn.itcast.user.utils.EmpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;

    int checkCount=0;


    /**
     * 根据id查找用户，这是个测试方法。
     * @param id
     * @return
     */
    @GetMapping("{id}")
    @ResponseBody
    public User queryUserById(@PathVariable("id")int id) {
        User user = userService.queryUserById(id);
        System.out.println(user.toString());
        return this.userService.queryUserById(id);
    }

    /**
     * 登陆方法
     * @param
     * @return
     */
    @GetMapping("login")
    public String login(HttpServletResponse httpServletResponse) {
        return "login";
    }

    /**
     *登陆验证
     * @param httpServletResponse
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    @GetMapping("check")
    public String check(ModelMap modelMap, HttpServletResponse httpServletResponse, String username, String password) throws Exception {

        //大致统计网站访问次数
        checkCount++;
        System.out.println(checkCount);

        User user = userService.queryUserByName(username);

        if(user == null) {
            httpServletResponse.setContentType("text/html;charset=utf-8");
            httpServletResponse.getWriter().write("<script>alert('用户不存在！');</script>");
            httpServletResponse.getWriter().flush();
        } else if(!user.getPassword().equals(password)) {
            httpServletResponse.setContentType("text/html;charset=utf-8");
            httpServletResponse.getWriter().write("<script>alert('密码输入错误！');</script>");
            httpServletResponse.getWriter().flush();
        } else if(Integer.parseInt(user.getStatus()) != 1) {
            httpServletResponse.setContentType("text/html;charset=utf-8");
            httpServletResponse.getWriter().write("<script>alert('用户状态被锁定，暂时无法登录！');</script>");
            httpServletResponse.getWriter().flush();
        } else {
            // 查询用户
            List<Student> students = this.studentService.queryAll();
            //System.out.println(students);
            // 放入模型
            modelMap.addAttribute("students", students);
            return "admin";
        }

        return "login";

    }


    /**
     * 从数据库查询要导出到excel的数据
     * @return
     */
    @GetMapping("export")
    public ResponseEntity<byte[]> exportEmp() {
        // 查询所有数据
        List<Student> studentsList = this.studentService.queryAll();
        return EmpUtils.exportEmp(studentsList);
    }


    /**
     * 返回admin视图
     * @param modelmap
     * @return
     */
    @GetMapping("admin")
    public String admin(ModelMap modelmap) {

        // 查询用户
        List<Student> students = this.studentService.queryAll();
        // 放入模型
        modelmap.addAttribute("students", students);

        return "admin";
    }


    @RequestMapping("findAll")
    @ResponseBody
    public List<Student> findAll(){
        List< Student> student = this.studentService.queryAll();
        return student;
    }


    /**
     *查询全部信息
     * @param model
     * @return
     */
    @GetMapping("/")
    public String all(ModelMap model) {
            // 查询用户
        List<User> users = this.userService.queryAll();
        //System.out.println(users);
        // 放入模型
        model.addAttribute("users", users);
        // 返回模板名称（就是classpath:/templates/目录下的html文件名）
        return "users";
    }

}
