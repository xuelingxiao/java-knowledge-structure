package com.xlx.pattern.proxy.my;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 代码生成,编译,重新加载到内存
 * 类加载器, 使用ClassLoader
 */
public class MyClassLoader extends ClassLoader{

    File basePath ;

    public MyClassLoader(){
        String basePath = MyClassLoader.class.getResource("").getPath();
        this.basePath = new File(basePath) ;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException{

        String className = MyClassLoader.class.getPackage().getName()+"."+name;

        if (null!=basePath){
            File classFile = new File(basePath,name.replaceAll("\\.","/")+".class");
            if (classFile.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out= null;
                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len=in.read(buffer))!=-1){
                        out.write(buffer,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    classFile.delete();
                    if (null!=in){
                        try{
                            in.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    if (null!=out){
                        try{
                            out.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        return null;
    }
}
