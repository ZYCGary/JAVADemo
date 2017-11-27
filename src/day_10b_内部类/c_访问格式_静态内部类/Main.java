package day_10b_内部类.c_访问格式_静态内部类;

class Outer{
    private static int num = 4;   //静态成员只能访问静态变量

    static class Inner{    //静态内部类，相当于外部类，与外部类同时加载
        void show(){
            System.out.println("show" + num);
        }

        //如果实在非静态的内部类中，是不能定义静态方法的：class Inner而不是static class Inner
        //因为如果Inner不是静态就不能直接加载，需要new对象才行
        static final int count = 5; //在非静态的内部类中只能定义静态的常量（final），而不能定义其他成员

        static void show1(){   //静态类方法可以直接访问
            System.out.println("show1" + num);
        }
    }
}


public class Main {

    public static void main(String[] args) {
        Outer.Inner in = new Outer.Inner();
        in.show();

        Outer.Inner.show1();    //直接访问静态、非私有的内部类的静态成员
    }
}

