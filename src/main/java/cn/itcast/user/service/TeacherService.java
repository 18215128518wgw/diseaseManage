package cn.itcast.user.service;

import cn.itcast.user.mapper.TeacherMapper;
import cn.itcast.user.pojo.Student;
import cn.itcast.user.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TeacherService {

    @Autowired(required = false)
    private TeacherMapper teacherMapper;
    private Teacher teacher;

    public boolean InsertTeacherInfo(Teacher teacher) {
        return this.teacherMapper.insert(teacher) == 1;
    }

    /**
     * 根据学号找到所有打卡记录，遍历记录，判断当天是否打卡
     * @param code
     * @param date
     * @return  若验证成功，返回假
     */
    public boolean checkTeacherByCode(String code, String date) {
        Teacher t = new Teacher();
        t.setCode(code);
        List<Teacher> r = teacherMapper.select(t);

        for (Teacher teacher : r) {
//            System.out.println(Integer.parseInt(student.getDate().substring(5,7)));
//            System.out.println(getMonth(new Date()));
            if(Integer.parseInt(teacher.getDate().substring(0,4)) == getYear(new Date()) && Integer.parseInt(teacher.getDate().substring(5,7)) - getMonth(new Date()) == 0 && Integer.parseInt(teacher.getDate().substring(8,10)) - getDay(new Date()) == 0){
                return false;
            }
        }

        return true;
    }


    /**
     * 根据学院找到所有教师
     * @param college
     * @return List<Student>
     */
    public List<Teacher> queryTeacherByCollege(String college) {
        Teacher t = new Teacher();
        t.setCollege(college);
        return teacherMapper.select(t);
    }


    /**
     * 查询全部教师信息
     * @return List<Teacher>
     */
    public List<Teacher> queryAll() {
        return this.teacherMapper.selectAll();
    }


    /**
     * 获取日期年份
     * @param date 日期
     * @returninteresting 返回年份
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }


    /**
     * 功能描述：返回月
     * @param
     * @return 返回月份
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }


    /**
     * 功能描述：返回日期
     *
     * @param date
     *            Date 日期
     * @return 返回日份
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

}
