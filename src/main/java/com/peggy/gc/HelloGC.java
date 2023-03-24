package com.peggy.gc;

import java.util.LinkedList;
import java.util.List;

/**
 * @author peggy
 * @date 2023-03-24 15:47
 */
public class HelloGC {
    static void newObcj() {
        final Object o = new Object();
        final byte[] bytes = new byte[104];
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println("HelloGC!");
        for (int i = 10; i < 1000; i++) {
            newObcj();
        }
        System.out.println("一共执行了" + (System.currentTimeMillis() - l) + "ms");
    }
}
