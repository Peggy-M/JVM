package com.peggy.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 自定义一个加密的 Class 文件
 * <p>
 * 通过前面的几个程序案例，其实对类加载这方面有一个整体的流程认知
 * 首先第一步
 * 对于一个我们编译后生成的 .class 类文件而言，这其中就包含了我们一个类的所有信息
 * 简单点说其实 .class 文件就是一个由 0/1 组成的一个二进制数据的文件
 * 无论是类文件加载执行我们的设定好的程序,还是通过类加载反射获取一个 .class 文件中的所有信息
 * 其实整个过程无非就是让虚拟机按照 Java 语言约定的某种规范,进行有二进制转化反或正向向解析的过程
 * 那么按照约定的规范去解析的整个过程当中,源 .class 文件必须遵守解析的规则去存储一个类的所有信息
 * 也就是说,生成类 .class 与 解析类需要一种规范去约束, 只要生成与解析两头的协议一旦出现不一致,就会导致
 * 解析获取源 .class 文件中的类信息的失败
 * <p>
 * 举个例子：
 * <p>
 * <p>
 * 原来中 Class 文件中的信息最原始信息
 * 假设 Hello.class 文件中的头标识与常量池大小用着一组数据表示
 * 11001010 11111110 10111010 10111110 00000000 00000000 00000000 00110011 00000000 00100011 00001010
 * 为了方便我们通常会转为 16 进行解析
 * CA FE BA BE 00 00 00 33 00 23 0A
 * <p>
 * 现在我们篡改这组信息让每一个二进制位都与 AF 做异或运算
 * 最终数据就会产生混乱
 * 该表我们原有的编码,而我们再次通过 getClass() 获取类对象的时候就会出现错误,及时通过反编译也无法解析类文件信息
 *
 * @author peggy
 * @date 2023-03-23 13:03
 */
public class T008_ClassLoaderPwd extends ClassLoader {
    private static final int SEED = 0B10100110;

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
                //这里进行解密
                bos.write(b^34);
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

    public static void main(String[] args) {
        ClassLoader l = new T008_ClassLoaderPwd();
        Class aClass = null;
        try {
            aClass = l.loadClass("com.peggy.classLoader.Hello");
            System.out.println(aClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
