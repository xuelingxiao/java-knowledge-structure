package serialization;

import com.alibaba.fastjson.JSON;
import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.caucho.hessian.io.Hessian2Output;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SerialTest {

    public static Car getCar() {
        return new Car(4, "Audi", "four circles");
    }


    public static void main(String[] args) throws IOException {
        testJackson();
        testFastJson();
        testProtoBuffer();
        testHessian();
    }


    /**
     * 使用jackson序列化
     *
     * @throws IOException
     */
    public static void testJackson() throws IOException {
        Car car = SerialTest.getCar();
        ObjectMapper mapper = new ObjectMapper();
        byte[] wirteBytes = null;
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            wirteBytes = mapper.writeValueAsBytes(car);
        }
        System.out.println("Json序列化: 时间--" + (System.currentTimeMillis() - start) + "ms; 大小--" + wirteBytes.length);
    }

    /**
     * 使用fastjson序列化
     */
    public static void testFastJson() {
        Car car = SerialTest.getCar();
        Long start = System.currentTimeMillis();
        String text = null;
        for (int i = 0; i < 1000; i++) {
            text = JSON.toJSONString(car);
        }
        System.out.println("FastJson序列化: 时间--" + (System.currentTimeMillis() - start) + "ms; 大小--" + text.getBytes().length);
        Object object = JSON.parse(text);
    }

    /**
     * 使用Protobuffer 序列化
     *
     * @throws IOException
     */
    public static void testProtoBuffer() throws IOException {
        Car car = SerialTest.getCar();
        Codec<Car> carCodec = ProtobufProxy.create(Car.class, false);
        Long start = System.currentTimeMillis();
        byte[] bytes = null;
        for (int i = 0; i < 1000; i++) {
            bytes = carCodec.encode(car);
        }
        System.out.println("ProtoBuffer序列化: 时间--" + (System.currentTimeMillis() - start) + "ms; 大小--" + bytes.length);
    }


    /**
     * 使用Hessian 序列化
     *
     * @throws IOException
     */
    public static void testHessian() throws IOException {
        Car car = SerialTest.getCar();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Hessian2Output hessian2Output = new Hessian2Output(byteArrayOutputStream);
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            hessian2Output.writeObject(car);
            hessian2Output.flush();
            if (i==0) {
                System.out.println("大小--" + byteArrayOutputStream.toByteArray().length);
            }
        }
        System.out.println("Hessian序列化: 时间--" + (System.currentTimeMillis() - start) + "ms; ");
    }

}
