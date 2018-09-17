package serialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QQ extends Car{

    private String area;

    @Override
    public String toString(){
        return "{name:"+this.getName()+";wheels:"+this.getWheels()+"desc:"+this.getDesc()+";area:"+this.getArea()+"}";
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializeCar();
        QQ car = deSerializeCar();
        System.out.println(car.toString());
    }


    private static void serializeCar() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("car")));
        QQ car = new QQ();
        car.setArea("china");
        car.setDesc("qq is great");
        car.setName("qq");
        car.setWheels(4);
        objectOutputStream.writeObject(car);
        objectOutputStream.close();
    }

    private static QQ deSerializeCar() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream;
        objectInputStream = new ObjectInputStream(new FileInputStream(new File("car")));
        QQ car = (QQ) objectInputStream.readObject();
        return car;
    }
}
