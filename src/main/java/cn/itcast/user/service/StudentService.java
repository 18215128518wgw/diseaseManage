package cn.itcast.user.service;

import cn.itcast.user.mapper.StudentMapper;
import cn.itcast.user.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    @Autowired(required = false)
    private StudentMapper studentMapper;
    private Student student;

    public boolean InsertStudentInfo(Student student) {
        return this.studentMapper.insert(student) == 1;
    }

    /**
     * 根据学号找到所有打卡记录，遍历记录，判断当天是否打卡
     * @param code
     * @param date
     * @return  若验证成功，返回假
     */
    public boolean checkStudentByCode(String code, String date) {
        Student s = new Student();
        s.setCode(code);
        List<Student> r = studentMapper.select(s);

        for (Student student : r) {
//            System.out.println(Integer.parseInt(student.getDate().substring(5,7)));
//            System.out.println(getMonth(new Date()));
            if(Integer.parseInt(student.getDate().substring(0,4)) == getYear(new Date()) && Integer.parseInt(student.getDate().substring(5,7)) - getMonth(new Date()) == 0 && Integer.parseInt(student.getDate().substring(8,10)) - getDay(new Date()) == 0){
                return false;
            }
        }

        return true;
    }


    /**
     * 根据学院找到所有学生
     * @param college
     * @return List<Student>
     */
    public List<Student> queryStudentByCollege(String college) {
        Student s = new Student();
        s.setCollege(college);
        return studentMapper.select(s);
    }


    /**
     * 查询全部信息
     * @return
     */
    public List<Student> queryAll() {
        return this.studentMapper.selectAll();
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
     *
     * @param date
     *            Date 日期
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
