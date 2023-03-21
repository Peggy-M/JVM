package com.peggy.classLoader;

/**
 * @author peggy
 * @date 2023-03-20 22:11
 */
public class T003_ClassLoader {
    public static void main(String[] args) {
        // App 类加载器
        System.out.println(T003_ClassLoader.class.getClassLoader());
        // 类加载器的类加载器为 Bootstrap
        System.out.println(T003_ClassLoader.class.getClassLoader().getClass().getClassLoader());
        // app 的父类加载器为 Extension
        System.out.println(T003_ClassLoader.class.getClassLoader().getParent());
        //  app 的父类加载器为 Extension 的父类加载器为 Bootstrap
        System.out.println(T003_ClassLoader.class.getClassLoader().getParent().getParent());
    }
}
