package day_14_多线程.t_守护线程;

/*
守护线程：后台线程
定义方法：new Thread().setDaemon()
线程结束方法：前台线程全部结束，后台线程自动结束

垃圾回收线程就是后台线程
 */

public class Main {
    public static void main (String[] args) {
        String[] strs = {"abc", "nba", "haha", "youdanyu"};

        sort(strs);
        printStrs(strs);
    }

    public static void printStrs (String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }

    public static void sort (String[] strs) {
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[i].compareTo(strs[j]) > 0) {
                    switchIndex(strs, i, j);
                }
            }
        }
    }

    public static void switchIndex (String[] strs, int i, int j) {
        String temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }

}

