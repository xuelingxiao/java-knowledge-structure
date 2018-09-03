package com.xlx.pattern.prototype;

import java.io.*;

public class DeepCloneBase implements Serializable {
    public Object deepClone() {
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayOutputStream.close();
                objectOutputStream.close();
                byteArrayInputStream.close();
                objectInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
