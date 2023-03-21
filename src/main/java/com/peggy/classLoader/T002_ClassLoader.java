package com.peggy.classLoader;

/**
 * @author peggy
 * @date 2023-03-20 21:12
 */
public class T002_ClassLoader {
    public static void main(String[] args) {
        //获取自定义的类的类加载器 App
        System.out.println(T002_ClassLoader.class.getClassLoader());
        //获取类加载器的类加载器 指向了 Bootstrap
        System.out.println(T002_ClassLoader.class.getClassLoader().getClass().getClassLoader());
        //获取类加载器的父类 Extension
        System.out.println(T002_ClassLoader.class.getClassLoader().getParent());
        //获取类加载器的父类的父类 Bootstrap
        System.out.println(T002_ClassLoader.class.getClassLoader().getParent().getParent());
    }
}
