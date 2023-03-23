package com.peggy.classLoader;

import org.w3c.dom.ls.LSOutput;

import java.io.*;

/**
 * 自定义 ClassLoader
 *
 * @author peggy
 * @date 2023-03-23 12:26
 */
public class T007_ClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        FileInputStream fis = null;
        ByteArrayOutputStream bos = null;
        File file = new File("E:/workspaces/java/afterEnd/JVM/target/classes", name.replaceAll(".", "/").concat(".class"));
        try {
            fis = new FileInputStream(file);
            bos = new ByteArrayOutputStream();
            int b = 0;

            while ((b = fis.read()) != 0) {
                bos.write(b);
            }
            byte[] bytes = bos.toByteArray();

            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return super.findClass(name);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader l = new T007_ClassLoader();
        Class aClass = l.loadClass("com.peggy.classLoader.Hello");
        //获取的当前类的加载器
        System.out.println(aClass.getClassLoader());
        //获取当前类的加载器的父类加载器
        System.out.println(aClass.getClassLoader().getParent());

    }
}
