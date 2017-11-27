package day_14_多线程.r_练习;

/*
1, 解决性别异常问题
分析：
    1，共享数据
    2，线程任务中是否有多条操作共享数据的代码

加了同步问题依旧：看同步前提(多个线程是否用的是一把锁——Input和Output用同一个锁)
               这个锁可以是Res.class(静态锁)、r、自定义锁
               但是不能用this、Object，因为他们不唯一

2, name和sex是私有，需要在Res中对外提供访问name和sex的方法
解决：创建set()和out()方法
发现：同步代码的位置不合适了，因为同步的其实是set()和out()
解决：使用同步函数

3，实现间隔输出，使用等待唤醒机制
一般情况下需要判断条件（标记flag）
或使用Lock接口和Condition接口
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Res{
    private String name;
    private String sex;
    // 定义标记
    private boolean flag;
    // 定义锁
    private final Lock lock = new ReentrantLock();
    // 获取监视器对象
    private Condition con = lock.newCondition();

    public void set(String name, String sex){
        lock.lock();

        try{
            while(flag){
                try{
                    con.await();
                }catch (InterruptedException e){}
            }
            this.name = name;
            this.sex = sex;
            flag = true;
            con.signal();
        }finally {
            lock.unlock();
        }

    }

    public void out(){
        lock.lock();

        try {
            while(!flag){
                try{
                    con.await();
                }catch (InterruptedException e){}
            }
            System.out.println(name + "...." + sex);
            flag = false;
            con.signal();
        }finally {
            lock.unlock();
        }

    }
}

class Input implements Runnable{
    private Res r;

    Input(Res r){
        this.r = r;
    }

    public void run(){
        int x = 0;

        while (true){
                if(x == 0){
                    r.set("Jack", "Male");
                } else {
                    r.set("Rose", "Female");
                }

            x = (x + 1) % 2;
        }
    }
}

class Output implements Runnable{
    private Res r;

    Output(Res r){
        this.r = r;
    }

    public void run(){

        while (true){
                r.out();
        }
    }
}

public class Main {
    public static void main (String[] args) {
        Res r = new Res();
        Input in = new Input(r);
        Output out = new Output(r);

        new Thread(in).start();
        new Thread(out).start();
    }
}
