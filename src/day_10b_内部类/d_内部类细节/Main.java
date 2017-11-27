package day_10b_内部类.d_内部类细节;

/*
为什么内部类可以直接访问外部类的成员？因为内部类持有外部的引用，即外部类名（this）
 */
class Outer{
    int num = 2;

    class Inner{
        int num = 3;

        void show(){
            int num = 4;
//            System.out.println("show.." + num);
//            System.out.println("show.." + this.num);
            System.out.println("show.." + Outer.this.num);
        }
    }

    public void method(){
        new Inner().show();
    }
}


//将内部类定义呆了局部的位置上
class Outer1{
    private int num = 4;
    Object obj;

    public void method(){
        final int x = 5;    //*******final不能丢，不然x是局部变量，不能被局部内部类Inner调用。因为生命周期不同********

        class Inner extends Object{    //局部内部类（Outer@1Inner.class）//Inner本身继承Object

            //覆盖Object中的toString方法
            public String toString(){
                System.out.println("show.." + num);
                System.out.println("x.." + x);
                return "Inner...abc";
            }
        }

        //创建内部类对象
        Inner in = new Inner();

        //将内部类的对象地址复制给obj
        obj = in;
    }

    public void function(){
        //打印obj指向的字符串的变现形式
        System.out.println(obj.toString());
    }
}

public class Main {

    public static void main(String[] args) {
        new Outer().method();
        new Outer1().method();
    }
}

