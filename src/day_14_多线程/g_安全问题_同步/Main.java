package day_14_多线程.g_安全问题_同步;

/*
多线程的安全问题：

产生的原因：
1，线程任务重有处理到共享的数据
2，线程任务中有多条对共享数据的操作
    一个线程在操作共享数据的过程中，其他线程参与了运算，造成了数据的错误

解决思想：
只要能保证多条操作共享数据的代码在某一时间段，被一条线程所执行，在执行期间不允许其他线程参与运算

方法：
引入同步代码块
synchronized(对象){
    //需要被同步的代码
}
 */

/*
好处
锁机制：目前情况下保证一次只能有一个线程在执行，其他线程进不来。解决了多线程的安全问题

弊端
降低效率，蓝菲资源。
 */

/*
有可能出现这样一种情况：
多线程安全问题出现后，加入了同步机制，没想到，问题依旧
原因：同步代码块出现问题

解决：只要遵守了同步的前提，既可以解决
     前提：多个线程在同步中必须使用同一个锁，这才是对多线程的同步 -- synchronized（new Object）是不可以的
 */

class SaleTicket implements Runnable{    //实现Runnable接口
    private int tickets = 1000;  //总票数
    Object obj = new Object();  //创建一个锁（例：火车上卫生间的门锁的只是标志：红／绿）

    //买票的代码需要被多个线程执行，所以要将这些代码定义到线程任务中。run方法。
    public void run(){

        while (true){
            synchronized (obj){
                if (tickets > 0){
                    //让线程到这里稍微停一下，发现出现：Thread-1....-1
                    try{
                        Thread.sleep(10);
                    }
                    catch (InterruptedException e){
                    }

                    System.out.println(Thread.currentThread().getName() + "...." + tickets --);
                }
            }
        }
    }
}

public class Main {
    public static void main (String[] args) {
        //现在可以买两种不同的票
        SaleTicket s = new SaleTicket();

        // 要让资源与线程分离，需要实现Runnable接口,将线程对象将线程的任务解耦
        // Runnable暴露出任务给线程对象，让其运行任务

        // 创建四个线程,通过Thread对象
        // 如何让线程对象调用到SaleTicket对象的run()呢？
        // Runnable暴露出任务给线程对象，让其运行任务
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);
        Thread t4 = new Thread(s);

        // 输出顺序错乱是因为CPU是多核的，CPU_0早于CPU_1运行完，就提前输出了

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
