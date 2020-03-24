package cn.itcast.user.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "college")
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String college;

    private String password;

    private Integer totalStudent;

    private Integer totalTeacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(Integer totalStudent) {
        this.totalStudent = totalStudent;
    }

    public Integer getTotalTeacher() {
        return totalTeacher;
    }

    public void setTotalTeacher(Integer totalTeacher) {
        this.totalTeacher = totalTeacher;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", college='" + college + '\'' +
                ", password='" + password + '\'' +
                ", totalStudent='" + totalStudent + '\'' +
                ", totalTeacher=" + totalTeacher +
                '}';
    }
}
