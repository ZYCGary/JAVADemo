package day_14_多线程.u_Join方法;

class Demo implements Runnable{
    public void run(){
        for (int x = 0; x <= 40; x++){
            System.out.println(Thread.currentThread().toString() + "...." + x);
        }
    }
}

public class Main {
    public static void main (String[] args) throws InterruptedException{
        Demo d = new Demo();
        Thread t1 = new Thread(d);
        Thread t2 = new Thread(d);

        t1.start();
//        t1.join();  // 等待该线程终止，即main线程进入冻结状态，直至t1线程终止后再唤醒main线程
        t2.start();

        t1.setPriority(Thread.MAX_PRIORITY);

        for (int x = 1; x <= 40; x++){
            System.out.println(Thread.currentThread().toString() + "...." + x);
        }
    }
}

/*
Thread[Thread-1,5,main] [线程名，优先级，线程组]
优先级：1(MIN_PRIORITY)-10(MAX_PRIORITY)  默认值：5
设置：setPriority()

yield(): 临时暂停当前线程，立即释放CPU执行权，使线程运行和谐
 */