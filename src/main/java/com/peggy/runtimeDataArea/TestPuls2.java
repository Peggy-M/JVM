package com.peggy.runtimeDataArea;

/**
 *
 *      0 new #2 <com/peggy/runtimeDataArea/TestPuls2> 创建对象 这里只是在创建但对象本身还没有生成
 *      Create new object
 *      3 dup 将方法 test() 压入虚拟机栈的栈帧中
 *      Duplicate the top operand stack value
 *      4 invokespecial #3 <com/peggy/runtimeDataArea/TestPuls2.<init> : ()V> 动态链接到方法,这里调用的就是 TestPuls2 的构造方法
 *      Invoke instance method; direct invocation of instance initialization methods and methods of the current class and its supertypes
 *      7 astore_1 将其地址的引用加载到局部变量编号为 1 ,也就是 TestPuls2 的引用
 *      Store reference into local variable
 *      8 aload_1 将局部变量的引用加载到内存
 *      Load reference from local variable
 *      9 invokevirtual #4 <com/peggy/runtimeDataArea/TestPuls2.test : ()I> 调用局部变量引用中的方法
 *     12 pop TestPuls2 对象中的 test() 方法执行完毕,从虚拟机栈的栈帧中弹出，弹出
 *     Pop the top operand stack value
 *     13 return
 *
 * @author peggy
 * @date 2023-03-24 10:28
 */
public class TestPuls2 {
    public int test() {
        int i=100;
        return i;
    }

    public static void main(String[] args) {
        TestPuls2 testPuls2 = new TestPuls2();
        testPuls2.test();
    }
}
