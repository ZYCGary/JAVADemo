package day_09c_多态.b_代码体现及好处;

//多态的好处：提高了代码的扩展性

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
//        Animal a = new Dog();
//        a.eat();
//
//        Animal a1 = new Cat();
//        a1.eat();

        //定义了狗和猫的调用方式，如果现在出现了猪的子类,那么还要定义调用猪的方法，扩展性差
        //既然都调用eat()，而eat是动物的共同行为，为什么不直接面对Animal呢？
        //直接定义共性的参数更合适

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
