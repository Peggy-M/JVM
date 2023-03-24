package com.peggy.invokeDynamic;

/**
 * invokeSpecial 不需要多态的调用
 * 调用的肯定是不需要多态的比如一些私有的构造方法
 * 又或者是 final 修饰的方法也是无法有多态的
 * 无法通过继承几不存在多态
 *
 *  0 new #2 <com/peggy/invokeDynamic/T03_invokeSpecial>
 *  3 dup
 *  4 invokespecial #3 <com/peggy/invokeDynamic/T03_invokeSpecial.<init> : ()V>
 *  7 astore_1
 *  8 aload_1
 *  9 invokevirtual #4 <com/peggy/invokeDynamic/T03_invokeSpecial.m1 : ()V>
 *  12 return
 *
 * @author peggy
 * @date 2023-03-24 11:16
 */
public class T03_invokeSpecial {
    public final void m1(){

    }

    private T03_invokeSpecial() {
    }

    public static void main(String[] args) {
        final T03_invokeSpecial t03InvokeSpecial = new T03_invokeSpecial();
        t03InvokeSpecial.m1();
    }
}
