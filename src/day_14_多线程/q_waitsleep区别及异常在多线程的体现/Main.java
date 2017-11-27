package day_14_多线程.q_waitsleep区别及异常在多线程的体现;

/*
wait() 与 sleep() 的区别：
相同：可以让此案成处于冻结状态

不同：
1，wait()可以指定时间，也可以不指定
   sleep()必须指定
2，wait()释放CPU资源，且释放锁
   sleep()释放CPU资源，但不释放锁
 */

class Demo implements Runnable{
    public void run(){
        System.out.println(4 / 0);
    }
}
public class Main {
    public static void main (String[] args) throws Exception{
        new Thread(new Demo()).start();
        Thread.sleep(10);
        int[] arr = new int[3];
        System.out.println(arr[2]);
        System.out.println("over");
    }
}

/*
报错：Exception in thread "Thread-0"
解释：Thread-0线程上发生了异常，异常的发生结束了此线程
     而main线程没有出现异常，所以可以正常运行，输出了0，over
 */