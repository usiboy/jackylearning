package jackylearning.hessian;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianFactory;
import com.caucho.hessian.io.SerializerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 使用{@link HessianFactory}创建序列化对象
 * @author liumingjian
 * @date 2018/7/12
 **/
public class HessianFactoryMain extends MainBase{

    public static void main(String[] args) throws IOException {
        HessianFactory factory = new HessianFactory();
        SerializerFactory serializerFactory = new SerializerFactory();
        // 设置了setAllowNonSerializable， 序列化的对象可以不用实现Serializable接口，这样也可以序列化这个对象
        serializerFactory.setAllowNonSerializable(true);
        factory.setSerializerFactory(serializerFactory);

        Company company = buildCompany();
        long start = System.currentTimeMillis();
        System.out.println("开始序列化company对象");
        byte[] data = serialize2Bin(factory, company);
        System.out.println("序列化成功，耗时:" + (System.currentTimeMillis() - start) + " ms.");
        printBin(data);

        start = System.currentTimeMillis();
        System.out.println("开始反序列化company对象");
        company = desrialize(factory, data, Company.class);
        System.out.println("反序列化成功，耗时" + (System.currentTimeMillis() - start) + " ms.");
        System.out.println(company);


        // SportsCar集成了Car，并重载了color字段，导致这里Hessian反序列化之后，color字段被parent覆盖为null
        // 这个问题也是Hessian目前比较难解决的问题
        SportsCar sportsCar = buildSportsCar();
        start = System.currentTimeMillis();
        System.out.println("开始序列化sportsCar对象");
        data = serialize2Bin(factory, sportsCar);
        System.out.println("序列化成功，耗时:" + (System.currentTimeMillis() - start) + " ms.");
        printBin(data);

        start = System.currentTimeMillis();
        System.out.println("开始反序列化sportsCar对象");
        sportsCar = desrialize(factory, data, SportsCar.class);
        System.out.println("反序列化成功，耗时" + (System.currentTimeMillis() - start) + " ms.");
        System.out.println(sportsCar);
    }

    static byte[] serialize2Bin(HessianFactory factory, Object obj) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Hessian2Output output = factory.createHessian2Output(baos);
        try {
            output.writeObject(obj);
        }finally {
            output.close();
        }
        return baos.toByteArray();
    }

    static <T> T desrialize(HessianFactory factory, byte[] data, Class<T> type) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        Hessian2Input input = factory.createHessian2Input(bais);
        try{
            return (T) input.readObject(type);
        }finally {
            input.close();
        }
    }
}
