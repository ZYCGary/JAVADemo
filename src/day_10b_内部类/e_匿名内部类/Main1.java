package day_10b_内部类.e_匿名内部类;

/*
匿名局部类：简化书写的内部类

前提：
    内部类需要继承或实现外部的类或接口

格式：
    new 父类or接口名（）{子类的内容}、

匿名内部类其实就是子类对象
 */

abstract class Demo{
    abstract void show();
}

class Outer{
    private int num = 4;
    //    class Inner{
//        //复写
//        public void show(){
//            System.out.println("show..." + num);
//        }
//    }
//
//    public void method(){
//        new Inner().show();
//    }
    public void method(){
        new Demo(){
            //覆盖Demo中的抽象方法
            public void show(){
                System.out.println("show.." + num);
            }
        }.show();
    }
}
public class Main1 {

    public static void main(String[] args) {
        new Outer().method();
    }
}

