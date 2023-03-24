package com.peggy.invokeDynamic;

/**
 * InvokeVirtuar
 *
 *  0 new #2 <com/peggy/invokeDynamic/T02_InvokeVirtuar>
 *  3 dup
 *  4 invokespecial #3 <com/peggy/invokeDynamic/T02_InvokeVirtuar.<init> : ()V>
 *  7 astore_1
 *  8 aload_1
 *  9 invokevirtual #4 <com/peggy/invokeDynamic/T02_InvokeVirtualFather.m1 : ()V>
 *  12 return
 *
 * 自带多态的执行
 * @author peggy
 * @date 2023-03-24 11:37
 */
public class T02_InvokeVirtuar extends T02_InvokeVirtualFather {

    public static void main(String[] args) {
        T02_InvokeVirtualFather t02InvokeVirtual = new T02_InvokeVirtuar() ;
        t02InvokeVirtual.m1();
    }
}
