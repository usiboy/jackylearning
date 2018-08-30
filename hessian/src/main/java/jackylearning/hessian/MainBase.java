package jackylearning.hessian;

import java.util.Arrays;
import java.util.Date;

/**
 * @author liumingjian
 * @date 2018/7/12
 **/
public class MainBase {

    protected static Company buildCompany(){
        Company company = new Company();
        company.setCreated(new Date());
        company.setId(1L);
        company.setName("xxxxxx");
        company.setRegisteredCapital(1000000.00D);
        Employee employee1 = new Employee();
        employee1.setAge(18);
        employee1.setId(1L);
        employee1.setName("Jacky LIU1");
        employee1.setSex((short) 1);

        Employee employee2 = new Employee();
        employee2.setAge(20);
        employee2.setId(2L);
        employee2.setName("Jacky LIU2");
        employee2.setSex((short) 2);
        company.setEmployees(Arrays.asList(employee1, employee2));
        return company;
    }

    protected static SportsCar buildSportsCar(){
        SportsCar car = new SportsCar();
        car.setCreated(new Date());
        car.setColor(1);
        return car;
    }

    /**
     * 将二进制数据打印成16进制的数据
     * @param data
     */
    protected static void printBin(byte[] data){
        System.out.println(new String(data));
    }
}
