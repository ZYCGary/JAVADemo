package day_16_API对象String.a_概述;

public class Main {
    public static void main (String[] args) {

        /*
        String 演示
        "abcd"
        1,常量，一旦初始化就不会被改变。
        2,
         */

        String str = "abcd";
//        str = "hello";
        String str1 = new String("abcd");

        System.out.println(str==str1);  //false,比较地址值
        System.out.println(str1.equals(str1));  //true，字符串的equals覆盖了Object类，比较的是内容

        // 问：str与str1的区别
        /*
        str在内存中只有一个对象，存放到 常量池 中
        str1在内存中有两个对象，堆内存 + 常量池
         */

        System.out.println("--------------");
        String s1 = "abc";
        String s2 = "abc";

        System.out.println(s1 == s2);
    }
}
