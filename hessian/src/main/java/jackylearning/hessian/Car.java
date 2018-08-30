package jackylearning.hessian;

import java.io.Serializable;
import java.util.Date;

/**
 * 汽车类，子类将会有跑车，并也增加一个属性为color的字段，用来测试Hessian多态上的支持
 * @author liumingjian
 * @date 2018/7/12
 **/
public class Car implements Serializable {
    private static final long serialVersionUID = 2412222174827959715L;

    private Date created;

    private Integer color;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "created=" + created +
                ", color=" + color +
                '}';
    }
}
