package day_14_多线程.m_死锁演示;

/*
死锁：

场景一：
同步嵌套
 */

class SaleTicket implements Runnable{
    private int tickets = 10;
    Object obj = new Object();
    boolean flag = true;

    public void run(){
        if (flag)
            while (true){
                synchronized (obj){   //obj lock
                    sale();
                }
        }
        else
            while (true)
                sale();
    }

    public synchronized void sale(){    //this lock
        synchronized (obj){
            if (tickets > 0){
                try {
                    Thread.sleep(10);
                }
                catch (InterruptedException e){
                }

                System.out.println(Thread.currentThread().getName() + "..." + tickets --);
            }
        }
    }
}

public class TicketDemo {

    public static void main (String[] args) throws InterruptedException{
        SaleTicket t = new SaleTicket();

        Thread t1 = new Thread();
        Thread t2 = new Thread();

        t1.start();
        Thread.sleep(10);
        t.flag = false;
        t2.start();
    }
}
