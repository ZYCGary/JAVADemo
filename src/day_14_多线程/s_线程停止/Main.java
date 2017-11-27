package day_14_多线程.s_线程停止;

/*
如何停止线程
原理：让run()结束
    线程任务通常都有循环。 因为开启线程就是为了执行需要一些时间的代码。
    只要控制循环，就可以结束run()
    控制循环船舰一个标记即可。定义变量
 */


class StopThread implements Runnable{
    private boolean flag = true;

    public void run(){
        while(flag){
            try{
                wait();
            } catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName() + "...." + e.toString());
                flag = false;   //return;
            }
            System.out.println(Thread.currentThread().getName() + "....Hello");
        }
    }

    public void changeFlag(){
        flag = false;
    }
}

public class Main {
    public static void main (String[] args) {
        StopThread st = new StopThread();
        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);

        t1.start();
        t2.start();
        for (int i = 1; i < 50; i++) {
            if (i == 40) {
//                st.changeFlag();
                t1.interrupt(); // 中断t1
                t2.interrupt(); // 中断t2
            }
            System.out.println("i = " + i);
        }

        System.out.println("over");
    }
}
