package cn.itcast.user.controller;

import cn.itcast.user.pojo.College;
import cn.itcast.user.pojo.Student;
import cn.itcast.user.pojo.Teacher;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.CollegeService;
import cn.itcast.user.service.StudentService;
import cn.itcast.user.service.TeacherService;
import cn.itcast.user.service.UserService;
import cn.itcast.user.utils.EmpUtils;
import cn.itcast.user.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private TeacherService teacherService;

//    int checkCount=0;
    int msgCount = 7;

    /**
     * 登陆方法
     * @param
     * @return
     */
    @GetMapping("login")
    public String login(Model model, HttpServletResponse httpServletResponse) {

        List<String> collegeName = this.collegeService.queryKindOfCollege().stream().map(College::getCollege).collect(Collectors.toList());
        // 放入模型
        model.addAttribute("collegeName", collegeName);
        model.addAttribute("msgCount", msgCount);

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

        //大致统计后台网站访问次数
//        checkCount++;
//        System.out.println("后台网站访问次数：" + checkCount + "    时间：" + new Date());
//        System.out.println(username + " , " + password);

        List<College> colleges = collegeService.querypasswordByCollege(username);

        if(colleges == null) {
            httpServletResponse.setContentType("text/html;charset=utf-8");
            httpServletResponse.getWriter().write("<script>alert('用户不存在！');</script>");
            httpServletResponse.getWriter().flush();
        } else if(!colleges.get(0).getPassword().equals(password)) {
            httpServletResponse.setContentType("text/html;charset=utf-8");
            httpServletResponse.getWriter().write("<script>alert('密码输入错误！');</script>");
            httpServletResponse.getWriter().flush();
        } else {
            if(colleges.get(0).getCollege().equals("学校防控办")) {
                // 查询用户
                List<Student> students = this.studentService.queryAll();
                // 放入模型
                modelMap.addAttribute("students", students);
                // 查询用户
                List<Teacher> teachers = this.teacherService.queryAll();
                // 放入模型
                modelMap.addAttribute("teachers", teachers);

                List<String> collegeName = this.collegeService.queryKindOfCollege().stream().map(College::getCollege).collect(Collectors.toList());
                // 放入模型
                collegeName.remove(0);
                modelMap.addAttribute("collegeName", collegeName);
                return "admin2";
            }else {
                String value = colleges.get(0).getCollege();

                List<Student> students = this.studentService.queryStudentByCollege(value);

                List<Teacher> teachers = this.teacherService.queryTeacherByCollege(value);

                // 放入模型
                modelMap.addAttribute("value", value);
                modelMap.addAttribute("students", students);
                modelMap.addAttribute("teachers", teachers);
                return "college2";
            }

        }

        List<String> collegeName = this.collegeService.queryKindOfCollege().stream().map(College::getCollege).collect(Collectors.toList());
        // 放入模型
        modelMap.addAttribute("collegeName", collegeName);
        modelMap.addAttribute("msgCount", msgCount);
        return "login";

    }

    /**
     * 返回主界面视图
     * @param modelMap
     * @return
     */
    @GetMapping("admin")
    public String admin(ModelMap modelMap) {
        // 查询用户
        List<Student> students = this.studentService.queryAll();
        // 放入模型
        modelMap.addAttribute("students", students);

        // 查询用户
        List<Teacher> teachers = this.teacherService.queryAll();
        // 放入模型
        modelMap.addAttribute("teachers", teachers);

        List<String> collegeName = this.collegeService.queryKindOfCollege().stream().map(College::getCollege).collect(Collectors.toList());
        // 放入模型
        collegeName.remove(0);
        modelMap.addAttribute("collegeName", collegeName);
        return "admin2";
    }

    @GetMapping("addCollege")
    public String addCollege(ModelMap modelMap) {
        List<String> collegeName = this.collegeService.queryKindOfCollege().stream().map(College::getCollege).collect(Collectors.toList());
        // 放入模型
        collegeName.remove(0);
        modelMap.addAttribute("collegeName", collegeName);
        return "addCollege";
    }

    @GetMapping("add")
    public String add(HttpServletResponse httpServletResponse, College college) throws Exception {

        if(this.collegeService.insertCollege(college)) {
            httpServletResponse.setContentType("text/html;charset=utf-8");
            httpServletResponse.getWriter().write("<script>alert('学院添加成功！');</script>");
            httpServletResponse.getWriter().flush();
        }
        return "addCollege";
    }

    @GetMapping("colleges")
    public String colleges(String value, ModelMap modelMap) {

        List<String> collegeName = this.collegeService.queryKindOfCollege().stream().map(College::getCollege).collect(Collectors.toList());
        collegeName.remove(0);

        List<Student> students = this.studentService.queryStudentByCollege(value);

        List<Teacher> teachers = this.teacherService.queryTeacherByCollege(value);

        // 放入模型
        modelMap.addAttribute("collegeName", collegeName);
        modelMap.addAttribute("value", value);
        modelMap.addAttribute("students", students);
        modelMap.addAttribute("teachers", teachers);

        return "college";

    }


    @GetMapping("table")
    public String table(ModelMap modelMap) {
        List<String> collegeName = this.collegeService.queryKindOfCollege().stream().map(College::getCollege).collect(Collectors.toList());
        // 放入模型
        collegeName.remove(0);
        modelMap.addAttribute("collegeName", collegeName);
        return "table";
    }


    /**
     * 从数据库查询要导出到excel的数据
     * @return
     */
    @GetMapping("export")
    public ResponseEntity<byte[]> exportEmp() {

        System.out.println("执行导出excel操作");
        // 查询所有数据
        List<Student> studentsList = this.studentService.queryAll();
        return EmpUtils.exportEmp(studentsList);
    }

    /**
     * 从数据库查询要导出到excel的数据
     * @return
     */
    @GetMapping("export2")
    public ResponseEntity<byte[]> exportEmp2() {

        System.out.println("执行导出excel操作");
        // 查询所有数据
        List<Teacher> teachersList = this.teacherService.queryAll();
        return EmpUtils.exportEmp2(teachersList);
    }


    /**
     * 查询所有学生
     * @return
     */
    @RequestMapping("findAllStudent")
    @ResponseBody
    public List<Student> findAllStudent(){

        List< Student> student = this.studentService.queryAll();
        return student;

    }

    /**
     * 查询所有教师
     * @return
     */
    @RequestMapping("findAllTeacher")
    @ResponseBody
    public List<Teacher> findAllTeacher(){

        List< Teacher> teacher = this.teacherService.queryAll();
        return teacher;

    }


    /**
     * 退出方法
     * @return
     */
    @GetMapping("quit")
    public String quit(Model model) {
        List<String> collegeName = this.collegeService.queryKindOfCollege().stream().map(College::getCollege).collect(Collectors.toList());
        // 放入模型
        model.addAttribute("collegeName", collegeName);
        model.addAttribute("msgCount", msgCount);
        return "login";
    }

    @GetMapping("sendMsg")
    public String sengMsg(String phoneNumber, Model model, HttpServletResponse httpServletResponse) throws Exception {
        List<String> collegeName = this.collegeService.queryKindOfCollege().stream().map(College::getCollege).collect(Collectors.toList());
        // 放入模型
        model.addAttribute("collegeName", collegeName);
        model.addAttribute("msgCount", msgCount);


        try {
            MsgUtils.SendSms(phoneNumber);
//            System.out.println(phoneNumber);
            msgCount -- ;
        } catch (Exception e) {
            httpServletResponse.setContentType("text/html;charset=utf-8");
            httpServletResponse.getWriter().write("<script>alert('短信下发失败，可能是免费条数用完了，也可能是手机号填错了');</script>");
            httpServletResponse.getWriter().flush();
        } finally {
            httpServletResponse.setContentType("text/html;charset=utf-8");
            httpServletResponse.getWriter().write("<script>alert('短信下发成功！');</script>");
            httpServletResponse.getWriter().flush();
        }

        model.addAttribute("msgCount", msgCount);
        System.out.println("发送短信");
        return "login";
    }


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


}
