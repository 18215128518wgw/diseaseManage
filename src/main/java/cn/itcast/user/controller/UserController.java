package cn.itcast.user.controller;

import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 测试方法
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

    @GetMapping("test")
    @ResponseBody
    public String test() {
        return "userController";
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
