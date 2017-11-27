package day_09c_多态.c_代码弊端及前提;

//多态的弊端：不能使用子类的特有方法（eg.guard(),catch(),sleep()）
/*多态的前提
    1，必须有关系：继承、实现
    2，通常有覆盖
 */

abstract class Animal{
    abstract void eat();
}


class Dog extends Animal{
    void eat(){
        System.out.println("bones");
    }
    void gaurd(){
        System.out.println("看家");
    }
}


class Cat extends Animal{
    void eat(){
        System.out.println("fish");
    }
    void catchMouse(){
        System.out.println("抓老鼠");
    }
}


class Pig extends Animal{
    void eat(){
        System.out.println("siliao");
    }

    void sleep(){
        System.out.println("sleep");
    }
}


public class Main {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();
        Animal a3 = new Pig();

        method(a1);
        method(a2);
        method(a3);

    }

    public static void method(Animal a){    //a可以指向任何一个动物
        a.eat();
    }
}

