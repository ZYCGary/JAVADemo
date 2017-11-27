package day_09b_接口.a_概述;

/*抽象类所有的方法都是抽象的
这时，可以把抽象类用另一种形式来表示——接口

初期可以理解为借口是特殊的抽象类
 */

/*
接口中常见的成员：
1，全局常量
2，抽象方法
他们都有固定的修饰符 public
 */

interface Inter{
    int NUM = 4;    //省略了 public static final
    void show1();  //省略了 public abstract
    void show2();
}

/*
接口的特点：
1，接口不可以实例化
2，需要覆盖接口中的所有的抽象方法的子类，才可以实例化
3，接口是用来被实现的
 */

//类与接口的关系是实现关系
class Demo implements Inter{
    public void show1(){

    };
    public void show2(){

    };
}


public class Main {

    public static void main(String[] args) {
        Demo d = new Demo();
    }
}

