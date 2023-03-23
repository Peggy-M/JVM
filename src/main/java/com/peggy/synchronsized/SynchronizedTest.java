package com.peggy.synchronsized;

/**
 * 关于 Synchronized 的底层实现
 *
 *    0 ldc #2 <com/peggy/synchronsized/SynchronizedTest>
 *    2 dup
 *    3 astore_1
 *    4 monitorenter  监视器重入
 *    5 aload_1
 *    6 monitorexit  这里如果出现异常监视器释放
 *    7 goto 15 (+8)
 *   10 astore_2
 *   11 aload_1
 *   12 monitorexit  这里方法执行完毕监视器释放
 *   13 aload_2
 *   14 athrow
 *   15 return
 *
 *   在字节码的层面  ACC_SYNCHRONIZED
 *   在 JVM 层面 由于 Synchronized 的底层实现是通过 C与C++ 的
 *   所以就直接由 C/C++ 调用了操作系统的同步机制
 *   在硬件层面 x86 通过 lock 指令 比如 cmpxchg 通过期望值与修改值进行加锁
 *
 * @author peggy
 * @date 2023-03-23 19:24
 */
public class SynchronizedTest {

    public synchronized void test() {

    }

    public static void main(String[] args) {
        synchronized (SynchronizedTest.class) {

        }
    }
}
