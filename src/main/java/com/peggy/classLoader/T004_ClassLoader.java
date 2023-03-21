package com.peggy.classLoader;

/**
 * 关于通过指定加载的包获取默认加载的类路径
 * @author peggy
 * @date 2023-03-20 22:27
 *
 * D:\DevEnvironment\Java\jdk1.8\bin\java.exe "
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\resources.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\rt.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\jsse.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\jce.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\charsets.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\jfr.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\classes
 * -----------------------------
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\ext
 * C:\Windows\Sun\Java\lib\ext
 * -----------------------------
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\charsets.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\deploy.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\ext\access-bridge-64.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\ext\cldrdata.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\ext\dnsns.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\ext\jaccess.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\ext\jfxrt.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\ext\localedata.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\ext\nashorn.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\ext\sunec.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\ext\sunjce_provider.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\ext\sunmscapi.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\ext\sunpkcs11.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\ext\zipfs.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\javaws.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\jce.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\jfr.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\jfxswt.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\jsse.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\management-agent.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\plugin.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\resources.jar
 * D:\DevEnvironment\Java\jdk1.8\jre\lib\rt.jar
 * E:\workspaces\java\afterEnd\JVM\target\classes
 * D:\Program Files\JetBrains\IntelliJ IDEA 2022.3.2\lib\idea_rt.jar
 * -----------------------------
 * -----------------------------
 */
public class T004_ClassLoader {
    public static void main(String[] args) {

        // String bootClassPath = System.getProperty("sun.boot.class.path");
        String pathBoot=System.getProperty("sun.boot.class.path");
        System.out.println(pathBoot.replaceAll(";",System.lineSeparator()));
        System.out.println("-----------------------------");

        //String var0 = System.getProperty("java.ext.dirs");
        String pathExt=System.getProperty("java.ext.dirs");
        System.out.println(pathExt.replaceAll(";",System.lineSeparator()));
        System.out.println("-----------------------------");

        //String var1 = System.getProperty("java.class.path");
        String pathApp=System.getProperty("java.class.path");
        System.out.println(pathApp.replaceAll(";",System.lineSeparator()));
        System.out.println("-----------------------------");
    }
}
