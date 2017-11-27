package day_13_面向对象练习题.exercise_7;

/**
 * 写出下面代码的执行结果
 */

/*
结果：
 */

class A{

    void fun1(){
        System.out.println(fun2());     //this.fun2()指向的是new B
    }

    int fun2(){
        return 123;
    }
}

class B extends A{
    int fun2(){
        return 456;
    }
}

class Main{
    public static void main (String[] args) {
        A a;
        B b = new B();
        b.fun1();
        a = b;      //A a = new B;
        a.fun1();   //new B.fun2();
    }
}
