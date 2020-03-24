package cn.itcast.user.pojo;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String college;

    private String date;

    private String name;

    private String phone;

    private String province;

    private String city;

    private String area;

    private Integer StayAtSchool;

    private Integer IfWuhanperson;

    private Integer IfHubeiperson;

    private Integer WithWuhanMeet;

    private Integer WithHubeiMeet;

    private Integer InWuhan;

    private Integer InHubei;

    private Integer BackToSchool;

    private Integer suspect;

    private Integer infect;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getStayAtSchool() {
        return StayAtSchool;
    }

    public void setStayAtSchool(Integer stayAtSchool) {
        StayAtSchool = stayAtSchool;
    }

    public Integer getIfWuhanperson() {
        return IfWuhanperson;
    }

    public void setIfWuhanperson(Integer ifWuhanperson) {
        IfWuhanperson = ifWuhanperson;
    }

    public Integer getIfHubeiperson() {
        return IfHubeiperson;
    }

    public void setIfHubeiperson(Integer ifHubeiperson) {
        IfHubeiperson = ifHubeiperson;
    }

    public Integer getWithWuhanMeet() {
        return WithWuhanMeet;
    }

    public void setWithWuhanMeet(Integer withWuhanMeet) {
        WithWuhanMeet = withWuhanMeet;
    }

    public Integer getWithHubeiMeet() {
        return WithHubeiMeet;
    }

    public void setWithHubeiMeet(Integer withHubeiMeet) {
        WithHubeiMeet = withHubeiMeet;
    }

    public Integer getInWuhan() {
        return InWuhan;
    }

    public void setInWuhan(Integer inWuhan) {
        InWuhan = inWuhan;
    }

    public Integer getInHubei() {
        return InHubei;
    }

    public void setInHubei(Integer inHubei) {
        InHubei = inHubei;
    }

    public Integer getBackToSchool() {
        return BackToSchool;
    }

    public void setBackToSchool(Integer backToSchool) {
        BackToSchool = backToSchool;
    }

    public Integer getSuspect() {
        return suspect;
    }

    public void setSuspect(Integer suspect) {
        this.suspect = suspect;
    }

    public Integer getInfect() {
        return infect;
    }

    public void setInfect(Integer infect) {
        this.infect = infect;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id + '\'' +
                ", code='" + code + '\'' +
                ", college='" + college + '\'' +
                ", date=" + date + '\'' +
                ", name=" + name + '\'' +
                ", phone=" + phone + '\'' +
                ", province=" + province + '\'' +
                ", city=" + city + '\'' +
                ", area=" + area + '\'' +
                ", StayAtSchool=" + StayAtSchool + '\'' +
                ", IfWuhanperson=" + IfWuhanperson + '\'' +
                ", IfHubeiperson=" + IfHubeiperson + '\'' +
                ", WithWuhanMeet=" + WithWuhanMeet + '\'' +
                ", WithHubeiMeet=" + WithHubeiMeet + '\'' +
                ", InWuhan=" + InWuhan + '\'' +
                ", BackToSchool=" + BackToSchool + '\'' +
                ", suspect=" + suspect + '\'' +
                ", infect=" + infect + '\'' +
                '}';
    }
}
