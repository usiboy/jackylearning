package jackylearning.hessian;

/**
 * @author liumingjian
 * @date 2018/7/12
 **/
public class SportsCar extends Car {
    private static final long serialVersionUID = -5445561080863377059L;

    private Integer color;

    @Override
    public Integer getColor() {
        return color;
    }

    @Override
    public void setColor(Integer color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "SportsCar{" +
                "color=" + color +
                '}';
    }
}
