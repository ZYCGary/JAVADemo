package day_14_多线程.f_创建线程的方式二_实现Runnable接口;

/*********************
 * 创建想成的第二种方式。实现Runnable接口
 * 1，定义一个Runnable类
 * 2，覆盖Runnable接口中的run(),将线程要运行的任务代码储存到该方法中
 * 3，通过Thread类创建线程对象，并将实现了Runnable接口的对象作为Thread类的构造函数的参数进行传递
 * 4，调用Thread类的start()，并开启线程
 *********************/

/*
实现Runnable接口的好处：
1，避免了继承Thread类的单继承的局限性
2，Runnable接口的出现更符合面向对象将线程单独进行对象的封装
3，降低了线程对象和线程任务的耦合性
所以，今后创建对象都使用Runnable
 */

class SaleTicket implements Runnable{    //实现Runnable接口
    private int tickets = 100;  //总票数

    //买票的代码需要被多个线程执行，所以要将这些代码定义到线程任务中。run方法。
    public void run(){

        while (true){

            if (tickets > 0){
                System.out.println(Thread.currentThread().getName() + "...." + tickets --);

            }
        }
    }
}
public class TicketDemo {

    public static void main (String[] args) {
        //现在可以买两种不同的票
        SaleTicket s1 = new SaleTicket();
        SaleTicket s2 = new SaleTicket();

        // 要让资源与线程分离，需要实现Runnable接口,将线程对象将线程的任务解耦
        // Runnable暴露出任务给线程对象，让其运行任务

        // 创建四个线程,通过Thread对象
        // 如何让线程对象调用到SaleTicket对象的run()呢？
        // Runnable暴露出任务给线程对象，让其运行任务
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s1);
        Thread t3 = new Thread(s2);
        Thread t4 = new Thread(s2);

        // 输出顺序错乱是因为CPU是多核的，CPU_0早于CPU_1运行完，就提前输出了

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
