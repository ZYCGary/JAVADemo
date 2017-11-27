package day_14_多线程.i_验证同步函数锁是this;

/*
验证同步函数实用的锁是this

眼胀需求：
启动两个线程：一个执行同步代码块（明锁）
           另一份使用同步函数（this锁）
两个线程执行的任务都是一样的。如果他们没有使用同一个锁，说明他们没有同步会出现同步错误

怎么能让一个线程在同步代码块中，一个在同步函数呢？
可以通过切换方式，定义boolean标记
 */
class SaleTicket extends Thread{
    private int tickets = 10;  //总票数
    Object obj = new Object();
    boolean flag = true;    //定义一个boolean标记

    public void run(){
        if (flag){
            while (true){
                synchronized (obj){    //synchronized (this)
                    if (tickets > 0){
                        try{
                            Thread.sleep(10);
                        }
                        catch (InterruptedException e){
                        }

                        System.out.println("..code.." + tickets --);

                    }
                }

            }
        }
        else {
            while(true)
                sale();
        }
    }

    public synchronized void sale(){
        if (tickets > 0){
            try{
                Thread.sleep(10);
            }
            catch (InterruptedException e){
            }

            System.out.println("..func.." + tickets --);

        }
    }
}

public class TicketDemo {

    public static void main (String[] args) throws InterruptedException{
        SaleTicket t = new SaleTicket();
        SaleTicket t1 = new SaleTicket();
        SaleTicket t2 = new SaleTicket();

        t1.start();
        Thread.sleep(500);
        t.flag = true;
        t2.start();
    }

}

