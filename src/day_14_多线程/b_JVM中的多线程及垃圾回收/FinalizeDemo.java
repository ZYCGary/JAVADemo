package day_14_多线程.b_JVM中的多线程及垃圾回收;
/*
多线程的运行根据CPU的切换完成。怎么切换，CPU说的算。所以多线程运行有随机性

JVM中的多线程：至少有两个线程
    1,负责自定义代码运行的
    2,负责回收垃圾的

********************************
通过实践发现每次结果比一定相同，这是因为随机性造成的
而且每一个线程都有运行的代码的内容，这称之为线程的任务
之所以创建线程就是为了去运行指定的任务代码
********************************

而线程的任务都封装在特定的区域中
比如：主线程运行的任务都定义在main方法中
     垃圾回收线程在回收垃圾时都会运行finalize方法
 */

class Demo{
    //定义垃圾回收方法
    public void finalize(){
        System.out.println("Demo Over...");
    }
}

public class FinalizeDemo {
    public static void main (String[] args) {
        new Demo();
        new Demo();
        new Demo();
        new Demo();     //匿名对象，形成垃圾，需要回收
        System.gc();    //启动垃圾回收器
        System.out.println("Hello World!");
    }
}
