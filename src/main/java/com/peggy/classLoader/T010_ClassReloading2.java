package com.peggy.classLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLClassLoader;
import java.security.SecureClassLoader;

/**
 * 打破双亲委派机制加载
 * @author peggy
 * @date 2023-03-23 14:42
 */
public class T010_ClassReloading2 {
    private static class MyLoader extends ClassLoader{
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            File file = new File("E:/workspaces/java/afterEnd/JVM/target/classes", name.replaceAll(".", "/").concat(".class"));
            if(!file.exists()) return super.loadClass(name);

            try {
                InputStream inputStream=new FileInputStream(file);

                byte[] bytes=new byte[inputStream.available()];

                inputStream.read(bytes);

                return defineClass(name,bytes,0, bytes.length);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return super.loadClass(name);
        }
    }

    public static void main(String[] args) {

        ClassLoader classLoader = new T008_ClassLoaderPwd();
        try {
            MyLoader m1=new MyLoader();
            final Class<?> aClass1 = m1.loadClass("com.peggy.classLoader.Hello");
            
            MyLoader m2=new MyLoader();
            final Class<?> aClass2 = m2.loadClass("com.peggy.classLoader.Hello");

            final Class<?> aClass3 = classLoader.loadClass("com.peggy.classLoader.Hello");
            final Class<?> aClass4 = classLoader.loadClass("com.peggy.classLoader.Hello");
            System.out.println(aClass2==aClass1);
            System.out.println(aClass3==aClass4);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
