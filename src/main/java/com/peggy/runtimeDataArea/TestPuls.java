package com.peggy.runtimeDataArea;

/**
 * 栈帧的内部
 * 局部标量表
 * 操作数栈
 * 动态链接
 * 返回时的方法区
 *
 *  0 bipush 8 (将 8 又 byte 转为 int 压入到当前的栈中)
 *  The immediate byte is sign-extended to an int value.  That value is pushed onto the operand stack.
 *  2 istore_1 (将栈中的值弹出 赋值给局部变量 i （这里的1代表的就是编号为 1 的局部变量，编号为 0 的局部变量是 args）)
 *  Store int into local variable
 *  3 iload_1 (从局部变量中加载值并转为 int)
 *  Load int from local variable
 *  4 iinc 1 by 1 (将局部变量编号为 1 的变量 加 1)
 *  Increment local variable by constant
 *  ！！！ 将局部变量加 1 ！！！
 *  7 istore_1 (将栈顶编号为 1 的值,赋值给局部变量 i（这里的1代表的就是编号为 1 的局部变量，编号为 0 的局部变量是 args）)
 *  ！！！ 这里其实 i 直接从局部变表中获取又变为了 8 ！！！
 *  Store int into local variable
 *  8 getstatic #2 <java/lang/System.out : Ljava/io/PrintStream;> （这里就开始调用新的打印方法）
 *  Get static field from class
 * 11 iload_1 (同样的从局部变量中取出编号为了 1 的变量 转为 int 类型)
 * Load int from local variable
 * 12 invokevirtual #3 <java/io/PrintStream.println : (I)V> (调用局部的方法)
 * Invoke instance method; dispatch based on class
 * 15 return （无效的返回）
 * Return void from method
 *
 * 0 iconst_1 (将整数常量压入栈中)
 * Push int constant
 * 1 ireturn (返回 int 类型)
 * Return int from method
 *
 * @author peggy
 * @date 2023-03-24 9:22
 */

/**
 *  0 bipush 8              0 bipush 8
 *  2 istore_1              2 istore_1
 *  3 iinc 1 by 1           3 iload_1
 *  6 iload_1               4 iinc 1 by 1
 *  7 istore_1              7 istore_1
 *  8 getstatic             8 getstatic #2
 * 11 iload_1              11 iload_1
 * 12 invokevirtual        12 invokevirtual #3
 * 15 return               15 return
 *
 */

public class TestPuls {
    public static void main(String[] args) {
        int i=8;
        i=i++;
//        i=++i;
        System.out.println(i);
    }
    /*
       该方法中有一个默认初始的局部变量 this
       在 static 的方法中的是不存在的
       因为静态的方法的对象本身就是类本身唯一的
       但是普通方法中的 this 对象是无法确定的
     */
    public int test(){
        return 1;
    }
}
