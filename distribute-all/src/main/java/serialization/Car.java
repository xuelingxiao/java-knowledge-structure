package serialization;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Serializable{

    // 版本号, java通过此版本号是否一致判断是否可以执行反序列化
    // 名称的数据类型必须准确,否则只是相当于定义一个普通的静态变量
    public static long serialVersionUID = -1244L;

    // 静态变量不序列化
    public static int age = 10;

    // 用protobuffer的话, 需要field上加Protobuffer的注解
    @Protobuf(fieldType = FieldType.INT32,order = 1)
    private int wheels;
    @Protobuf(fieldType = FieldType.STRING,order = 2)
    private String name;

    // 瞬时变量, 不被序列化
    private transient String desc;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //serializeCar();
        Car car = deSerializeCar();
        System.out.println(car.age);
        System.out.println(car.toString());
    }

    private static void serializeCar() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("car")));
        Car car = new Car(4, "BMW", "fast....");
        objectOutputStream.writeObject(car);
        car.age = 12;
        objectOutputStream.close();
    }

    private static Car deSerializeCar() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream;
        objectInputStream = new ObjectInputStream(new FileInputStream(new File("car")));
        Car car = (Car) objectInputStream.readObject();
        return car;
    }
}
