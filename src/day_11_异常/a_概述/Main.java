package day_11_异常.a_概述;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[1];
        System.out.println(arr[1]); //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 1
        //at Main.main(Main.java:5)
    }
}
/*
异常：java程序子运行时起发生的不正常的情况

java就按照面向对象的思想对异常进行了描述和封装

问题分两种：
    Exception：由jvm发生的，并告诉使用者。可以针对性的处理
    Error：由系统底层发生的（如：内存溢出）。不做针对性的处理，必须修改代码。

Throwable：java中所有Exception和Error的超类。
当发生异常时，jvm就将已知问题封装成了对象
throw new ArrayIndexOutOfBoundException(1); 将问题抛给使用者main函数
main没有针对性的处理方式，main就继续往外抛给调用者jvm，jvm就是用默认的处理方式
将问题名称+信息+位置 在控制台上显示，并结束程序。
 */
