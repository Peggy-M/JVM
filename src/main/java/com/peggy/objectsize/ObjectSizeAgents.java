package com.peggy.objectsize;

import java.lang.instrument.Instrumentation;

/**
 * 创建一个获取对象大小的工具类
 * 将定义的具有 premain 方法类打包成 jar 文件
 * 同时需要在 META-INF 目录下创建 MANIFEST.MF
 * 并标明一下参数
 * Manifest-Version: 1.0 //版本（可以忽略）
 * Created-By: mashibing.com    //所在的扫描包路径 （可以忽略）
 * Premain-Class: com.mashibing.jvm.agent.ObjectSizeAgent  //包路径 （必须参数）
 *
 *
 * -javaagent:E:\workspaces\java\DesignPatternes\SizeAget\target\SizeAget-1.0-SNAPSHOT.jar
 *
 * @author peggy
 * @date 2023-03-23 21:06
 */
public class ObjectSizeAgents {
    private static Instrumentation inst;

    //这个在加载的时候会优先于 main 方法之前执行
    //premain 方法格式与参数是固定的
    public static void premain(String agentArgs, Instrumentation _inst) {
        inst = _inst;
    }
    //在外调用次方法就可以获取其对象
    public static long sizeOf(Object obj){
        return inst.getObjectSize(obj);
    }
}
