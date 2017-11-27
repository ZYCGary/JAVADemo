package day_14_多线程.h_同步函数;

/**
 * 两个储户，到同一个银行存钱，每个人存了3次，一次100元
 * 1，描述银行
 * 2，描述储户任务
 */

/*分析多线程是否存在安全隐患
    1，线程任务中是否有共享的数据：d，add()，num
    2，是否多条线程共享数据的代码


同步函数：其实就是在函数上加上了同步关键字进行修饰

同步表现形式有两种：
    同步代码块
    同步函数

同步函数实用的锁是什么呢？
    函数需要被对象调用，对象不确定，都用this表示，所以锁就是this
*/

class Bank{
    private int sum;

    public synchronized void add(int n){
            sum = sum + n;
            System.out.println("sun = " + sum);
    }
}

class Customer implements Runnable{
    private Bank b = new Bank();

    public void run(){
        for (int i = 0; i < 3; i ++){
            b.add(100);
        }
    }
}

public class Main {

    public static void main (String[] args) {
        // 1, 创建任务对象
        Customer c = new Customer();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}
