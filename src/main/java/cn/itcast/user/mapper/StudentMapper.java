package cn.itcast.user.mapper;

import cn.itcast.user.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends tk.mybatis.mapper.common.Mapper<Student>{
}

