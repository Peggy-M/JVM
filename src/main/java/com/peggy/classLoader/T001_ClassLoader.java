package com.peggy.classLoader;

/**
 *
 * Bootstrap 与 Extension 和 app
 * Bootstrap 加载 lib / rt.jar charset.jar 等核心的类 是由于 C++ 实现的
 * Extension 加载扩展包 jre/lib/ext/*.jar 或者由 -Djava.ext.dirs 指定
 * app 加载 classpath 指定的内容
 * Custom ClassLoader 自定义的类加载器
 *
 * @author peggy
 * @date 2023-03-20 21:17
 */
public class T001_ClassLoader {
    public static void main(String[] args) {
        //由于 Bootstrap 是由 C++ 实现的所以是没有对象的为空
        System.out.println(String.class.getClassLoader());
        //该类也是一个核心类库所以加载的是 Bootstrap 类加载器所以也为空值
        System.out.println(sun.awt.HKSCS.class.getClassLoader());
        //该类由 Extension 类加载器 加载
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        //该类是由 App 类加载器加载
        System.out.println(T001_ClassLoader.class.getClassLoader());
        // Extension 的父加载器为 Extension 加载器,所以不为空
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getParent());
        // App 的类加载器的父类加载器为 Extension 输出
        System.out.println(T001_ClassLoader.class.getClassLoader().getParent());

        /**
         * 输出结果:
         * ===================================================
         * = null
         * = null
         * = sun.misc.Launcher$ExtClassLoader@677327b6
         * = sun.misc.Launcher$AppClassLoader@18b4aac2
         * = null
         * = sun.misc.Launcher$ExtClassLoader@677327b6
         * ===================================================
         */
    }
}
