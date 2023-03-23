package com.peggy.objectsize;

import com.peggy.ObjectSizeAgent;

/**
 * 测试自定义的 ObjectSizeAgnt 工具
 * @author peggy
 * @date 2023-03-23 21:24
 */
public class TestSizeAgnt {
    public static void main(String[] args) {
        System.out.println(ObjectSizeAgent.sizeOf(new Object()));
        System.out.println(ObjectSizeAgent.sizeOf(new int[2][2]));
        System.out.println(ObjectSizeAgent.sizeOf(new TestSizeAgnt()));

    }
}
