package day_09c_多态.d_向上向下转型;

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


public class Main {

    public static void main(String[] args) {
        Animal a1 = new Dog();  //向上转型：狗被提升为动物
        /*
        向上转型好处：隐藏了子类型，提高了代码的扩展性。
        向上转型弊端：只能使用父类的功能，不能使用子类的特有功能。

        使用情况：不需要面对子类型，通过提高拓展性，或者使用父类的功能即可完成操作
         */
        a1.eat();

        //如果需要子类型的特有功能呢？
        if (!(a1 instanceof Dog)){
            System.out.println("类型不匹配");
            return;
        }
        Dog d = (Dog)a1;    //向下转型
        d.eat();
        d.gaurd();
        /*
        向下转型的好处：可以只用子类型的特有功能
        向下转型的弊端：必须面对子类型，有风险 -- 假设new错了（new Cat），会发生ClassCastExpection，转型对象和对象不匹配
            解决方法：需要进行判断，判断他们是否匹配
                     关键字instanceof
        使用情况：需要子类特有的功能，但是一定要判断
         */
    }
}
