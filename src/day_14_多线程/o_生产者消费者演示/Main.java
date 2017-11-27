package day_14_多线程.o_生产者消费者演示;

/*
多线程间的通信
多线程都在处理同一个资源，但是处理的任务却不一样

生产者-消费者
通过同步，解决了没生产就消费的问题
但是出现了连续生产没有消费的情况

使用了等待、唤醒机制
wait()：可以让线程处于冻结状态，并让线程历史存储到线程池中
notify()：唤醒指定线程池中的某一个线程
notifyAll()：唤醒指定线程池中的所有线程

在使用这些方法是，必须标示他们所属于的锁。标示方式为  锁对象.wait()/锁对象.notify()
相同锁的notify可以获取相同锁的wait
 */


// 描述资源
class Resouse{
    private String name;
    private int count = 0;

    // 提供给商品赋值的方法
    public synchronized void set (String name){
        while (count >= 100)   // 判断为true，就wait；判断为false，就生产。
            try{
                this.wait();
            }
            catch (InterruptedException e){
            }

        count ++;

        this.name = name;

        System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name + "..." + count);

        // 唤醒消费者
        this.notify();
    }

    // 提供一个获取商品的方法
    public synchronized void get (){
        while (count == 0)
            try{
                this.wait();
            }
            catch (InterruptedException e){
            }

        count --;

        this.name = name;

        System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name + "..." + count);

        // 唤醒生产者
        this.notify();
    }
}

// 生产者
class Producer implements Runnable{
    private Resouse r;

    Producer (Resouse r){
            this.r = r;
    }

    public void run(){
        while (true){
            r.set("Bread");
        }
    }
}

// 消费者
class Customer implements Runnable{
    private Resouse r;

    Customer (Resouse r){
        this.r = r;
    }

    public void run(){
        while (true) {
            r.get();
        }
    }
}

public class Main {

    public static void main (String[] args) {
        Resouse r = new Resouse();

        Producer pro = new Producer(r);
        Customer cus = new Customer(r);

        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(cus);

        t1.start();
        t2.start();
    }
}
