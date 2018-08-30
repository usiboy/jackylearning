package jackylearning.hessian;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liumingjian
 * @date 2018/7/11
 **/
public class Company implements Serializable {

    private static final long serialVersionUID = 7454040935479480396L;
    private Long id;

    private String name;

    private Date created;

    /**
     * 注册资金
     */
    private Double registeredCapital;

    private List<Employee> employees;

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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Double getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(Double registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", registeredCapital=" + registeredCapital +
                ", employees=" + employees +
                '}';
    }
}
