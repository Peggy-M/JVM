package com.peggy.classLoader;

/**
 * @author peggy
 * @date 2023-03-23 14:18
 */
public class T009_ClassLoaderLever extends ClassLoader {
    private static T009_ClassLoaderLever parent =new T009_ClassLoaderLever();
    private static class MyLoader extends ClassLoader{
        public MyLoader() {
            super(parent);
        }
    }

    public static void main(String[] args) {
        System.out.println(new T009_ClassLoaderLever().getParent());
    }
}
