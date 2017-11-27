package day_11_异常.h_覆盖异常的使用;

//Exception
//    |--AException
//        |--AAException
//    |--BException

/*
覆盖时，子类方法覆盖父类方法，只能抛出父类方法异常或该异常的子类
如果父类方法抛出多个异常，子类只能抛出父类异常的子类
原则：就是子类的异常必须要在父类一查给处理控制中

有一种情况，只能try不能throw
被覆盖的方法没有抛出异常
那么子类在覆盖式，子类方法中发生异常，就只能try不能throws声明

interface Inter{
void show(){}
}

class Demo implements Inter{
    public void show(){
        try{
            throw new Exception();
        }
        catch(Exception e){
            throw new RunTimeException("");     //将编译时检测的异常，转化为运行异常，这样就不用声明
        }
    }
 */

class AException extends Exception{
}
class AAException extends AException{
}
class BException extends Exception{
}

class Parent{
    void show() throws AException{
        System.out.println("Parent show");
    }
}

class Tool{
    void method(Parent parent){
        try{
            parent.show();
        }

        catch (AException ae){
        }
    }
}

class Chld extends Parent {
    void show() throws AAException{    //可以抛A也可以抛AA，Tool的处理方式是处理A，而A可以处理它的子类异常AA；但是不能处理B异常
        System.out.println("Child show");
    }
}

public class Main {

    public static void main(String[] args) {
        Tool tool = new Tool();
        tool.method(new Parent());
        tool.method(new Chld());
    }
}
