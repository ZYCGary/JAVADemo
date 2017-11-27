package day_14_多线程.p_Lock接口及Condition接口;

/*
解决多生产多消费的效率问题，使用java,until.concirrent.locks包中的对象
Lock接口：比synchronized 有更多操作
    lock(): 获取锁
    unlock(): 释放锁

同步代码块的锁操作是隐式的
Lock接口按照面向对象的思想，将锁单独封装成了一个对象，并提供了对锁的显式操作

lock接口就是同步的替代。

将程序中的同步更换为Lock接口的形式。

问题：随着灵活性的增加，也带来了更多的责任。不使用同步就无法使用其在无法执行语句时自动释放锁功能
解决：使用finally

问题：替换完编译失败了，
原因：因为wait没有了同步区域，所以没有了同步锁。同步升级了，其中锁已经不是任意对象，而是Lock类型的对象
     那么和任意对象绑定的监视器方法，也升级了，有了专门和Lock类型锁绑定的监视器方法
     查阅API。Condition接口替代了Object中的监视器方法
     以前监视器方法封装到每一个对象中，现在将监视器方法封装到Condition接口中
     方法名为：await(), signal(), signalAll()

     锁可以自创建Condition对象，通过newCondition()
 */

import java.util.concurrent.locks.*;

class Res
{
    private String name;
    private int count;

    // 创建新锁
    private Lock lock = new ReentrantLock();

    // 创建与Lock绑定的监视器对象,分别创建生产和消费监视器
    private Condition pro_con = lock.newCondition();
    private Condition cus_con = lock.newCondition();

    public void set(String name) {

        // 获取锁
        lock.lock();

        try {
            while (count >= 100)   // 判断为true，就wait；判断为false，就生产。
                try {
                    pro_con.await();    // this.wait();
                } catch (InterruptedException e) {
                }

            count++;

            this.name = name;

            System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name + "..." + count);

            // 生产完毕，应该唤醒消费者
            cus_con.signalAll();    // this.notify();

        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    public synchronized void get (){
        while (count == 0)
            try{
                cus_con.await();
            }
            catch (InterruptedException e){
            }

        count --;

        this.name = name;

        System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name + "..." + count);

        // 消费完毕，应该唤醒生产者
        pro_con.signal();
    }
}
public class Main {
}
