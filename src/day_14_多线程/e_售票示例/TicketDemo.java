package day_14_多线程.e_售票示例;

class SaleTicket extends Thread{
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
        //创建4个线程（4个售票窗口），但是会创建400张票，不建议tickets变为static
        //不能让线程持有tickets这个资源
        //这时需要Runnable接口
        SaleTicket t1 = new SaleTicket();
        SaleTicket t2 = new SaleTicket();
        SaleTicket t3 = new SaleTicket();
        SaleTicket t4 = new SaleTicket();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
