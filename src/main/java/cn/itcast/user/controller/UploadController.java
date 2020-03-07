package cn.itcast.user.controller;

import cn.itcast.user.pojo.Student;
import cn.itcast.user.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private StudentService studentService;

    @GetMapping("student")
    public String StudentUpload(Model model){

        model.addAttribute("today", new Date());
        return "student";
    }

    @GetMapping("info")
    public String StudentInfo(Model model, Student student, HttpServletResponse httpServletResponse) throws Exception{

        System.out.println(student);

        if(studentService.InsertStudentInfo(student)) {
            //model.addAttribute("msg", "success");
            httpServletResponse.setContentType("text/html;charset=utf-8");
            httpServletResponse.getWriter().write("<script>alert('今日情况已上报成功！');</script>");
            httpServletResponse.getWriter().flush();
        } else {
            //model.addAttribute("msg", "fail");
            httpServletResponse.setContentType("text/html;charset=utf-8");
            httpServletResponse.getWriter().write( "<script>alert('上报失败，请重新上报！');</script>");
            httpServletResponse.getWriter().flush();
        }

        model.addAttribute("today", new Date());
        return "student";
    }




}
