package com.xlx.pattern.proxy.my;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 生成代理对象的代码, Proxy的具体原理在这里体现
 */
public class MyProxy {

    private static final String ln = "\r\n";

    public static Object newProxyInstance(MyClassLoader loader, Class<?>[] interfaces, MyInvocationHandler h) {
        File f = null;
        try {
            // 第一步: 生成源代码
            String src = generateSrc(interfaces[0]);

            // 第二步: 保存生成的源码文件
            String filePath = MyProxy.class.getResource("").getPath();
            f = new File(filePath + "/$Proxy0.java");
            FileWriter writer = new FileWriter(f);
            writer.write(src);
            writer.flush();
            writer.close();

            // 第三步: 编译生成.class文件
            JavaCompiler compliler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compliler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compliler.getTask(null, manager, null, null, null, iterable);
            ((JavaCompiler.CompilationTask) task).call();
            manager.close();

            // 第四步: 加载class字节码到内存(MyClassLoader类实现)
            Class proxyClass = loader.findClass("$Proxy0");
            // 第五步: 返回代理对象
            Constructor constructor = proxyClass.getConstructor(MyInvocationHandler.class);
            return constructor.newInstance(h);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != f) {
                f.delete();
            }
        }
        return null;
    }

    /**
     * 生成源码的方法
     *
     * @param interfaces 为了演示,按一个接口处理
     * @return
     */
    private static String generateSrc(Class<?> interfaces) {
        StringBuffer src = new StringBuffer();
        src.append("package com.xlx.pattern.proxy.my;" + ln);
        src.append("import java.lang.reflect.Method;" + ln);
        src.append("public class $Proxy0 extends MyProxy implements " + interfaces.getName() + "{" + ln);
        src.append("MyInvocationHandler h;" + ln);

        src.append("public $Proxy0(MyInvocationHandler h){" + ln);
        src.append("this.h=h;" + ln);
        src.append("}" + ln);

        // 循环定义方法,与被代理类的方法同名
        for (Method m : interfaces.getMethods()) {
            src.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + ln);

            src.append("try{" + ln);
            src.append("Method m =" + interfaces.getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
            src.append("this.h.invoke(this,m,null);" + ln);
            src.append("}catch(Throwable e){e.printStackTrace();}" + ln);
            src.append("}" + ln);
        }

        src.append("}" + ln);
        return src.toString();
    }
}
