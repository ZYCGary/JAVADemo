package day_10b_内部类.b_访问格式_非静态内部类;

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

        //如果内部类权限是非私有的，就可以再外部其他程序中被访问到。就可以通过撞见外部类对象完成
        //既然创建的是内部类对象，就可以调用内部类的方法
        Outer.Inner in = new Outer().new Inner();
        in.show();
    }
}
