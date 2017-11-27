package day_14_多线程.k_单例模式的并发访问;

// 饿汉式，相对与多线程并发，安全！
// 懒汉式（延迟加载方式）
/*
懒汉式会出现线程安全问题。
解决：同步函数或同步代码块
但是，效率低了，每次都要判断锁

解决效率低的问题：可以通过if对单例对象的双重判断形式
 */

/**
 * 饿汉式
 */
//class Single{
//    private static final Single SINGLE_INSTANCE = new Single();
//
//    private Single(){
//    }
//
//    public static Single getInstance(){
//        return SINGLE_INSTANCE;
//    }
//}

/**
 * 懒汉式
 */
class Single{
    private static Single s = null;
    private Single(){
    }

    public static  Single getInstance(){
        if (s == null){
            synchronized (Single.class){
                if (s == null)
                    s = new Single();
            }
        }
        return s;
    }
}


class Demo implements Runnable{
    public void run(){
        Single.getInstance();
    }
}

public class Main {
}
