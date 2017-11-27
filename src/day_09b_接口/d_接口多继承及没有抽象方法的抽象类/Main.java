package day_09b_接口.d_接口多继承及没有抽象方法的抽象类;

/*
类与类之间是继承关系（is a）
与接口之间是实现关系（like a）

接漏雨接口时间什么关系？--继承关系,还支持多继承
 */

interface Inter2{
    void show2();
}

interface Inter3{
    void show3();
}

interface Inter4 extends Inter2, Inter3{
    void show4();
}

class Demo1 implements Inter4{
    public void show2(){}
    public void show3(){}
    public void show4(){}
}
public class Main {
    public static void main(String[] args) {
        Demo1 d = new Demo1();
        d.show2();
        d.show3();
        d.show4();
    }
}


//问题：如果只需要实现接漏的部分功能，但是为了实例化，必须要全覆盖，代码复用性极差
//解决方法：创建一个类作为媒介，这个类对接口的所有方法进行龙实现，其他子类只需要继承这个类就ok了
//但是这个类创建的对象没有意义，所以定义为abstract
interface InterX{
    void show1();
    void show2();
    void show3();
    void show4();
}

abstract class DemoW implements InterX{
    public void show1(){};
    public void show2(){};
    public void show3(){};
    public void show4(){};
}
class DemoX extends DemoW{
    public void show1(){
        System.out.println("show1");
    }
}

class DemoY extends DemoW{
    public void show3(){
        System.out.println("show3");
    }
}
