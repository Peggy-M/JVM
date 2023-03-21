package com.peggy.classLoader;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 关于 ClassLoader 的双亲委派以及类模板模式
 *
 * 在 JDK 1.2 之前当时还没有双亲委派模型,但当时 ClassLoader 这个抽象类已经出现
 * 所以当时已经就有人继承这个抽象类,重写 loadClass 这个方法从而试图破坏双亲委派机制
 * 但现在已经无法直接通过继承 ClassLoader 的实现类对加载类的一些方法进行重写
 *
 *     protected Class<?> findClass(final String name) 由于有 protected 关键字
 *
 *     采用===>>> 模板模式
 *     抽象方法 findClass ====>>>
 *
 *      protected Class<?> findClass(String name) throws ClassNotFoundException {
 *         throw new ClassNotFoundException(name);
 *     }
 *
 * @author peggy
 * @date 2023-03-21 10:45
 */
public class T006_BasicsClassLoader extends URLClassLoader {

    //这里要求必须调用父类构造方法
    public T006_BasicsClassLoader(URL[] urls) {
        super(urls);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //这里直接返回调用的是父类的 findClass 的方法
//        protected Class<?> findClass(final String name)
        return super.findClass(name);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
