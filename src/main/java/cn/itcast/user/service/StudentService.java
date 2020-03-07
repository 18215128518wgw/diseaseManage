package cn.itcast.user.service;

import cn.itcast.user.mapper.StudentMapper;
import cn.itcast.user.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired(required = false)
    private StudentMapper studentMapper;

    public boolean InsertStudentInfo(Student student) {
        return this.studentMapper.insert(student) == 1;
    }

}
