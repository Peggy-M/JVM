package com.peggy.invokeDynamic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  invokeInterface 接口调用
 *  0 new #2 <java/util/ArrayList>
 *  3 dup
 *  4 invokespecial #3 <java/util/ArrayList.<init> : ()V>
 *  7 astore_1
 *  8 aload_1
 *  9 ldc #4 <卡卡罗特>
 *  11 invokeinterface #5 <java/util/List.add : (Ljava/lang/Object;)Z> count 2
 *  16 pop
 *  17 new #2 <java/util/ArrayList>
 *  20 dup
 *  21 invokespecial #3 <java/util/ArrayList.<init> : ()V>
 *  24 astore_2
 *  25 aload_2
 *  26 ldc #6 <特兰克斯>
 *  28 invokevirtual #7 <java/util/ArrayList.add : (Ljava/lang/Object;)Z>
 *  31 pop
 *  32 return
 *
 * @author peggy
 * @date 2023-03-24 11:20
 */
public class T04_InvokeInterface {
    public static void main(String[] args) {
        List<String> list=new ArrayList();
        list.add("卡卡罗特");
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("特兰克斯");
    }
}
