package cn.itcast.user.service;

import cn.itcast.user.mapper.CollegeMapper;
import cn.itcast.user.pojo.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CollegeService {

    @Autowired(required = false)
    private CollegeMapper collegeMapper;

    /**
     * 查询全部学院数据，包括校防疫办
     * @return
     */
    public List<College> queryKindOfCollege() {

        Example example = new Example(College.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("college"); //参数为 属性名
//        criteria.andLike("name","%"+name+"%");//like
//        criteria.andLessThanOrEqualTo("age",lessAge);//小于或等于
        example.orderBy("id").asc();//排序
        return collegeMapper.selectByExample(example);

    }

    /**
     * 增加学院
     * @param college
     * @return
     */
    public boolean insertCollege(College college) {
        return this.collegeMapper.insert(college) == 1;
    }


    /**
     * 根据学院名称查询密码
     * @param college
     * @return
     */
    public List<College> querypasswordByCollege(String college) {
        College c = new College();
        c.setCollege(college);
        return collegeMapper.select(c);
    }

}