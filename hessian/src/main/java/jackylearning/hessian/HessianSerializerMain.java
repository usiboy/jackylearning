package jackylearning.hessian;

import com.caucho.hessian.io.HessianSerializerOutput;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 使用{@link HessianSerializerOutput}和{@link com.caucho.hessian.io.HessianSerializerInput}进行序列化测试
 * @author liumingjian
 * @date 2018/7/11
 **/
public class HessianSerializerMain extends MainBase{

    public static void main(String[] args) throws IOException {
        Company company = buildCompany();
        long start = System.currentTimeMillis();
        System.out.println("开始序列化company对象");
        byte[] data = serialize2Bin(company);
        System.out.println("序列化成功，耗时:" + (System.currentTimeMillis() - start) + " ms.");
        printBin(data);
    }

    /**
     * 转换之前会判断下byte是否是可显示的字符，如果是可现实的，则不转换为16进制字符
     * Convert byte[] to hex string.这里我们可以将byte转换成int，然后利用Integer.toHexString(int)来转换成16进制字符串。
     *
     * @param src byte[] data
     * @return hex string
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return "";
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            stringBuilder.append("x");
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv).append(" ");
        }
        return stringBuilder.toString();
    }


    static byte[] serialize2Bin(Object obj) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HessianSerializerOutput output = new HessianSerializerOutput(baos);
        try {
            output.writeObject(obj);
        }finally {
            output.close();
        }
        return baos.toByteArray();
    }
}
