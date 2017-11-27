package day_14_多线程.d_继承Thread类;

/*
如何建立一个线程？

1，继承Thread类
    1）继承Thread类
    2）覆盖run()
    3）创建子类对象就是创建线程对象
    4）调用Thread类中的start()就会执行线程，并调用run()  **没有start()，线程就只是被创建，而没有运行
            start()开启线程后，就会执行run()，说明run()储存的是线程要运行的代码
            所以，自定义线程的任务代码都储存在run()中
 */

/************************
 调用start() 与 调用run() 的区别
 start：会开启线程，让开启的线程去执行这个线程内部的run()中的线程任务，执行run()的是被开启的线程
 run：线程并未开启，去执行run()的只有主线程
 **************************/

/*
多线程的运行状态  执行资格：可以被CPU访问到    执行权：正在调用CPU来运行线程     有资格不一定有执行权
1，被创建：new 一个线程对象
2，运行：start()，运行就是线程具备CPU的执行资格和执行权
3，消亡：run()结束
4，冻结：释放了CPU的执行权，同时释放了CPU的执行资格。
        sleep(time) --- sleep(time over)
        wait() --- notify()
5，临时阻塞：具备CPU的执行资格，不具备CPU的执行权，
            因为CPU是单线程运行，所以还没有被CPU运行到的线程就处于临时阻塞状态

 */

class Demo extends Thread{
    private String name;

    Demo(String name){
        this.name = name;
    }

    //覆盖run()
    public void run(){
//        System.out.println("run run");
        show();
    }

    public void show(){
        for(int i = 1; i <= 10; i ++){
//            System.out.println(getName() + "..." + name + "..." +i);    //获取当前线程自动生成的线程（对象）名,因为这个线程实际上是个对象
            System.out.println(Thread.currentThread().getName() + "..." + i);   //获取执行这个线程（对象）的线程的线程名(谁执行这句话，拿的就是谁的名字)
        }
    }
}
public class TreadDemo {
    public static void main (String[] args) {
        Demo d1 = new Demo("Gary");
        Demo d2 = new Demo("Lily");
        d1.start();     //1，开启线程  2，调用run()
//        d2.start();
        d1.run();   //主线程执行这个run()，因为d1没有被开启，只是它的run()被主线程执行了

        for(int i = 1; i < 10; i ++){
            System.out.println(Thread.currentThread() + "..." + i);     //获取当前这个线程的线程名
        }
    }
}

