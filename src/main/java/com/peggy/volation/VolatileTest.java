package com.peggy.volation;

/**
 * 关于 Volation 字节码层面的实现细节
 *
 * volation的底层调用关系
 *
 * 1、在我们编译好的字节码的层面只是添加了 一个 ACC_VOLATILE
 *
 * 2、在 JVM 层面也就是当 JVM 加载了我们编译好的 .class 字节码的时候，
 * 当扫描到 volation 关键字的时候就会自动的在 volation 所修饰的成员变量的前后添加屏障比如
 *
 * LoadLoadBarrier
 *
 * volatile 读操作
 *
 * LoadStoreBarrier
 *
 * 3、由于我们的虚拟机最终实现屏障的读写隔离都是最终还是依托的是我们的硬件。所以对于硬件层面不同的操作系统的实现是不用的，
 * 比如 Windows系统，在它的底层是通过 Lock 这样的指令实现的，
 * 而对于 Linux 系统其又是通过 store 与 lfence 这样的指令配合 lock 锁来实现隔离的。
 * @author peggy
 * @date 2023-03-23 17:08
 */
public class VolatileTest {

    int i = 10;
    volatile int k = 100;
}
