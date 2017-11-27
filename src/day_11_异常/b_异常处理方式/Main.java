package day_11_异常.b_异常处理方式;

/*
异常的处理。

处理方式：
1，遇到问题不进行具体的处理，而是继续抛给调用者
    通过throws声明异常，告诉调用者
2，针对性处理方式——捕获catch, 一旦出现异常抛给catch进行处理，处理后继续执行后面的外部代码
try{
    有可能发生异常的代码
}

catch(异常类  变量){
    这时真正的捕获，处理异常的代码；
}
fianlly{
    一定会被执行的代码
}


throw 与 throws 区别
1，位置不同：
    throws用在函数上，后面跟的是异常类，可以跟多个
    throw 用字函数内，后面跟的是异常对象，只能一个

2，功能不同：
    throws用来声明异常，让调用者知道该功能有可能出现的问题，并由调用正可以给出预先的处理方式
    throw 用来抛出具体的问题对象，执行到throw，功能就已经结束了就跳出功能，跳转到调用者，并将具体的问题对象抛给调用者
    也就是说throw语句独立存在时，下面不要定义其他语句，因为执行不到


异常体系的特殊情况：
    异常体系的最大特点是体系中的类以及类产生的对象，都具备可抛性（被throw 和throws 所操作）


异常原则：
1，功能内部有异常抛出，功能上一定要throws声明
   内部跑什么，功能上就声明什么，目的就是为了让调用者处理
   如果调用者不处理，编译失败

Exception 分两种：编译时会抛出的异常；因形式异常（编译时不检测）RunTimeException
2, 特殊情况：
    当函数内通过throw抛出了RunTimeException及其子类的异常对象时，函数上可以不用throw声明
    不声明的目的就是不让调用者处理，让调用者的程序停止，要对代码进行修改
    因为声明了就可以被处理，处理后程序就会继续运行，异常数据会被之后的代码运行，程序就废了
    不声明就写不出处理方式，异常就会被调用者看见，就会去该代码


 */

class Demo{
    /*
    在编写功能是，编写者知道该功能可能发生异常，而这个问题很容易来自调用者传递的参数
    而导致无法运行。这时就应该让调用者知道，并最好让调用者有预先的处理方式。
    所以在定义功能时，需要在功能是对有可能发生的问题进行声明
    关键字throws + 异常类
    目的：让调用者可以进行异常处理
     */
    int div(int a, int b) //throws Exception
    {
        if(b == 0){
            throw new ArithmeticException("除零啦！废啦！");
        }
        return a / b;   //问题出在这里，作为开发者，应该在此进行标示可能的异常
    }
}
public class Main {

    public static void main(String[] args)
    {
        Demo d = new Demo();

        try{
            int num = d.div(4, 2);  //ArithmeticException: / by zero
            System.out.println("num = " + num);
        }

        catch (Exception e){    //Exception e = ArithmeticException: / by zero
            //处理这个对象，可以使用该对象的方法
            System.out.println("Exception happen!");
            System.out.println(e.getMessage()); //异常信息
            System.out.println(e.toString());   //异常名称 + 异常信息
            e.printStackTrace();    //名字 + 信息 + 位置。 jvm默认处理收到的异常就是调用这个方法，将信息显示到屏幕
        }

        System.out.println("over");
    }
}

