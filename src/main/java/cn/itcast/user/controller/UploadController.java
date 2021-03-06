package cn.itcast.user.controller;

import cn.itcast.user.pojo.Student;
import cn.itcast.user.pojo.Teacher;
import cn.itcast.user.service.StudentService;
import cn.itcast.user.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("index")
public class UploadController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    int time = 22;
//    int checkCountq = 1;

    /**
     * 返回页面视图
     * @param model
     * @return
     */
    @GetMapping("index")
    public String StudentUpload(Model model){

//        System.out.println("前台网站访问次数：" + checkCountq + "    时间：" + new Date());
//        checkCountq++;
        model.addAttribute("today", new Date());
        return "upload";

    }

    /**
     * 表单提交的目标方法，判断条件是否允许，为真则向数据库写入数据
     * @param model
     * @param student
     * @param httpServletResponse
     * @return   打卡视图
     * @throws Exception
     */
    @GetMapping("info")
    public String StudentInfo(Model model, String kind, Student student, Teacher teacher, HttpServletResponse httpServletResponse) throws Exception{

        System.out.println(student);
        System.out.println(kind);

        if(kind.equals("student")) {
            //成功表示当日没有填写，并且时间未超过20点
            if(studentService.checkStudentByCode(student.getCode(), student.getDate()) && getHour(new Date()) < time){
                //判断插入到数据表中是否成果
                if(studentService.InsertStudentInfo(student)) {
                    httpServletResponse.setContentType("text/html;charset=utf-8");
                    httpServletResponse.getWriter().write("<script>alert('今日情况已上报成功！');</script>");
                    httpServletResponse.getWriter().flush();
                    System.out.println("上传成功");
                }else {
                    httpServletResponse.setContentType("text/html;charset=utf-8");
                    httpServletResponse.getWriter().write( "<script>alert('上报失败，请重新上报！');</script>");
                    httpServletResponse.getWriter().flush();
                    System.out.println("上传失败");
                }
            }else {
                if(getHour(new Date()) < time && !studentService.checkStudentByCode(student.getCode(), student.getDate())) {
                    httpServletResponse.setContentType("text/html;charset=utf-8");
                    httpServletResponse.getWriter().write( "<script>alert('您今日已打卡！');</script>");
                    httpServletResponse.getWriter().flush();
                    System.out.println("重复打卡");
                } else {
                    httpServletResponse.setContentType("text/html;charset=utf-8");
                    httpServletResponse.getWriter().write( "<script>alert('打卡时间超过规定时间！');</script>");
                    httpServletResponse.getWriter().flush();
                    System.out.println("打卡超时");
                }
            }
        }else if(kind.equals("teacher")) {
            //成功表示当日没有填写，并且时间未超过20点
            if(teacherService.checkTeacherByCode(teacher.getCode(), teacher.getDate()) && getHour(new Date()) < time){
                //判断插入到数据表中是否成果
                if(teacherService.InsertTeacherInfo(teacher)) {
                    httpServletResponse.setContentType("text/html;charset=utf-8");
                    httpServletResponse.getWriter().write("<script>alert('今日情况已上报成功！');</script>");
                    httpServletResponse.getWriter().flush();
                    System.out.println("上传成功");
                }else {
                    httpServletResponse.setContentType("text/html;charset=utf-8");
                    httpServletResponse.getWriter().write( "<script>alert('上报失败，请重新上报！');</script>");
                    httpServletResponse.getWriter().flush();
                    System.out.println("上传失败");
                }
            }else {
                if(getHour(new Date()) < time && !teacherService.checkTeacherByCode(teacher.getCode(), teacher.getDate())) {
                    httpServletResponse.setContentType("text/html;charset=utf-8");
                    httpServletResponse.getWriter().write( "<script>alert('您今日已打卡！');</script>");
                    httpServletResponse.getWriter().flush();
                    System.out.println("重复打卡");
                } else {
                    httpServletResponse.setContentType("text/html;charset=utf-8");
                    httpServletResponse.getWriter().write( "<script>alert('打卡时间超过规定时间！');</script>");
                    httpServletResponse.getWriter().flush();
                    System.out.println("打卡超时");
                }
            }
        }else {
            httpServletResponse.setContentType("text/html;charset=utf-8");
            httpServletResponse.getWriter().write("<script>alert('不存在此类角色！');</script>");
            httpServletResponse.getWriter().flush();
        }



        model.addAttribute("today", new Date());
        return "upload";
    }


    /**
     * 功能描述：返回小时 int
     *
     * @param date
     *
     * @return Integer 返回小时
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }


}
