package day_09a_抽象类.a_概述;

//描述狗：吼叫
//描述狼：吼叫
//两个事物具备共性，可以向上抽取-->犬科：吼叫

//描述一个事物，却没有足够的信息，这时就将这个事物成为抽象事物。eg.无法确定犬科动物的吼叫声
/*
 虽然不具体，但是简单化
不用面对具体事物

特点：
1，抽象方法一定定义在抽象类中，需要 abstract 来修饰
2，抽象类不能实例化。不能new
3，只有子类覆盖了所有的抽象方法后（子类具体化），子类就可以new对象了
	如果没有覆盖所有的抽象方法，那子类还是抽象方法，还是不能new对象

 */

/*
问题：
1，抽象类中有构造函数吗？
	有，虽然不能给抽象类对象实例化，因为抽象类不能创建对象，
	但是抽象类有子类，它的构造函数可以给子类的对象实例化。

	抽象类vs一般类：
	相同：都用来描述事物，都可以进行属性和行为的描述
	不同：抽象类描述事物的信息不具体
	           代码不同--抽象类中可以定义抽象方法，抽象类不能实例化

2，抽象类一定是父类吗？
	是的。想使用抽象类的功能必须要子类覆盖其方法后才可以实例化使用这些方法。

3，抽象类中可以不定义抽象方法吗？
	可以。仅仅是让该类不能创建对象。

4，抽象关键字abstract和那秀关键字不能共存？
	final，private，static
 */

abstract class Quanke{
    abstract void bark();
}

class Dog extends Quanke {
    void bark() {
        System.out.println("WongWong");
    }
}

class Wolf extends Quanke {
    void bark() {
        System.out.println("AwhAwh");
    }
}

public class Main {

    public static void main(String[] args) {
        Dog d = new Dog();
        d.bark();
    }

}
