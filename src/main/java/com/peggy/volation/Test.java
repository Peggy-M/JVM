package com.peggy.volation;

/**
 * 指令重排序
 * main 方法中的指令表
 *
 *      0 new #2 <com/peggy/volation/Test> 申请内存
 *      3 dup
 *      4 invokespecial #3 <com/peggy/volation/Test.<init> : ()V> 调用无参的构造方法创建对象给内存
 *      7 astore_1 将内存地址赋值给 test
 *      8 return
 * 在指令 4 与 指令 7 可能在运行的时候发生指令重排
 * @author peggy
 * @date 2023-03-23 15:53
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
    }
}
