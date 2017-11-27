package day_14_多线程.v_常见写法;

/*
两段代码执行没有先后顺序
2种常见写法
 */

public class Main {
    public static void main (String[] args) {

        //写法-1, new 一个路径
        new Thread() {
            public void run () {
                // 代码段1
                for (int x = 0; x <= 40; x++) {
                    System.out.println("x = " + x);
                }
            }
        }.start();

        //写法-2，new 一个任务
        Runnable r = new Runnable() {
            public void run () {
                // 代码段2
                for (int x = 0; x <= 40; x++) {
                    System.out.println("y = " + x);
                }
            }
        };
        new Thread(r).start();


        /**
         * 问：结果是什么？
         */
        new Thread(new Runnable() {
            @Override
            public void run () {
                System.out.println("runnable run...");
            }
        })

        {
            public void run () {
                System.out.println("subThread run...");
            }
        }.start();
    }
}
