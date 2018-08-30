package jackylearning.hessian;

import java.io.Serializable;

/**
 * 员工
 * @author liumingjian
 * @date 2018/7/11
 **/
public class Employee implements Serializable {

    private static final long serialVersionUID = -7705600775797211015L;
    private Long id;

    private String name;

    private Integer age;

    private Short sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
