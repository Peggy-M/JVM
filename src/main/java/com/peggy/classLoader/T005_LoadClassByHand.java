package com.peggy.classLoader;

/**
 * 利用类加载器加载资源
 * @author peggy
 * @date 2023-03-21 8:56
 */
public class T005_LoadClassByHand {
    public static void main(String[] args) {
        try {
            final Class<?> calss = T005_LoadClassByHand.class.getClassLoader().loadClass("com.peggy.classLoader.T004_ClassLoader");
            System.out.println(calss);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
