package day_14_多线程.j_验证static同步函数锁事类名class;

/*
如果同步函数被静态修饰呢？

静态方法随着类加载，设施不一定有该类的对象，但是一定有一个该类的自己吗文件对象
这个对象简单的表示方式就是类名.class  即Class
 */
class SaleTicket extends Thread implements Runnable{
    private static int tickets = 10;  //总票数
    Object obj = new Object();
    boolean flag = true;    //定义一个boolean标记

    public void run(){
       if (flag){
           while (true){
               synchronized (SaleTicket.class) {
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
       }
       else
           while (true)
               sale();
    }

    public static synchronized void sale(){    //同步函数变为static
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
        Thread t1 = new Thread();
        Thread t2 = new Thread();

        t1.start();
        t.flag = false;
        t2.start();
    }
}

