package day_14_多线程.n_死锁示例;

// 同步嵌套死锁

class Task implements Runnable{
    private boolean flag = true;

    Task(boolean flag){
        this.flag = flag;
    }

    public void run(){
        if (flag){
            while (true){
                synchronized (MyLock.LOCKA){
                    System.out.println("if...locka");
                    synchronized (MyLock.LOCKB){
                        System.out.println("if...lockb");
                    }
                }
            }
        }
        else {
            while (true){
                synchronized (MyLock.LOCKB){
                    System.out.println("else..lockb");
                    synchronized (MyLock.LOCKA){
                        System.out.println("else...locka");
                    }
                }
            }
        }
    }
}

class MyLock
{
    public static final Object LOCKA = new Object();
    public static final Object LOCKB = new Object();
}
public class DeadLockDemo {
    public static void main (String[] args) {
        Task t1 = new Task(true);
        Task t2 = new Task(false);

        new Thread(t1).start();
        new Thread(t2).start();
    }
}
