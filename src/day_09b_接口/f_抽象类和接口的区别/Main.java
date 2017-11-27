package day_09b_接口.f_抽象类和接口的区别;

//描述犬，里面有抽象的方法：吃、叫。具体由子类方法
//什么时候定义抽象类？什么时候定义抽象方法？--具体问题具体分析
abstract class Dog{
    abstract void eat();
    abstract void bark();
}


//需求：添加一个功能：缉毒。————单独描述几个缉毒功能的Dog
//分析：缉毒犬和Dog是什么关系呢？is a？like a？
//Dog用于描述所有功能犬的基本功能，要用class定义，不适合定义成interface
class JiduDog1 extends Dog{
    public void eat(){}
    public void bark(){}
    public void jidu(){}
}


//如果定义了一个缉毒猪🐷
//具备缉毒功能的有很多。缉毒功能需要抽取。抽取到class还是interface呢？
//都是一下，定义成class
abstract class Jidu1{
    abstract void Jidu();
}
//不行。缉毒犬如果成为Dog类，就不能继承Jidu类（因为类不能多继）

interface Jidu{
    void jidu();
}

class JiduDog2 extends Dog implements Jidu{
    public void eat(){}
    public void bark(){}
    public void jidu(){}
}
//可行

//**************************
//类用于描述事物的共性（基本功能），接口用于描述的是事物的额外功能
//把额外功能抽取出来定义为接口，任何子类想实现都可以，即使他们继承的是不同的类（缉毒犬🐩and缉毒猪🐷）
//例如：还可以定义导盲功能让导盲犬去继承
//***************************

public class Main {
}

/*
抽象类和接口的区别
1，is a --- like a
2,类中可以定义抽象和非抽象，接口定义的都是抽象方法
 */
