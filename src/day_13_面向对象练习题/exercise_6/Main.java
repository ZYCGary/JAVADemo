package day_13_面向对象练习题.exercise_6;

public class Main {
    private double d1 = 1.0;
    // insert code here
}

/*A*/
//class InnerOne{
//    public static double method(){
//        return d1;
//    }
//}
/**
 * 不可以，因为非静态内部类中，不可以定义静态方法
 */

/*B*/
//private class InnerOne{
//    protected double method(){
//        return d1;
//    }
//}
/**
 * 可以
 */

/*C*/
//static class InnerOne{
//    protected double method(){
//        return d1;
//    }
//}
/**
 * 不行，静态内部类只能访问外部类中的静态成员
 */

/*D*/
abstract class InnerOne{
    public abstract double method();
}
/**
 * 可以
 */

