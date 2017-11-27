package day_10b_内部类.e_匿名内部类;

/*
匿名内部类调用多方法
先定义一个匿名内部类，在调用多方法

不能使用情况：内部类的方法过于庞大不要用，否则可读性会极差
 */
interface Inter{
    void show1();
    void show2();
}

class Outer1{
    private int num = 4;

//    class Inner implements inter{
//        public void show1(){}
//        public void show2(){}
//    }
//
//    public void method(){
//        Inner in  = new Inner();
//        in.show1();
//        in.show2();
//    }

    public void method(){
        Inter in = new Inter(){
            public void show1(){}
            public void show2(){}
        };
        in.show1();
        in.show2();
    }
}
public class Main2 {
}

