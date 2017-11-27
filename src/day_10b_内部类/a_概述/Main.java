package day_10b_内部类.a_概述;

/*
内部类：将类定义到另一个类的内部。
A类要直接访问B类中的成员，可以将A定义到B中，作为其内部类。

访问规则：
    内部类可以直接访问外部类中的成员
    外部类想要访问内部类，只能创建对象来访问
 */

class Outer{
    private int num = 4;

    class Inner{    //内部类，相当于外部类的一个成员。他就可以被成员修饰符所修饰 public、private、static
        void show(){
            System.out.println(num);
        }
    }

    public void method(){
        Inner in = new Inner(); //Outer$Inner.class
        in.show();
    }
}


public class Main {

    public static void main(String[] args) {
        Outer out = new Outer();
        out.method();
    }
}

