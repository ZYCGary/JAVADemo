package day_08_继承.c_覆盖;
// 2. 方法函数的继承
/*
 * 特殊情况：子父类中出现完全相同方法（返回值，参数。。。）
 * 方法的覆盖（override）：子类对象运行的是子类的方法
 * 
 * 注意事项：
 * 1. 保证权限 >= 父类权限 public > 空 > private (但是如果父类方法是private，子类都无法访问，更不能覆盖)
 * 2. 静态只能覆盖静态，或者被静态覆盖
 * 3. 必须完全一样，否则会出现调用的不确定性
 */


// 例子

// 描述手机： 打电话，发短信，来电显示
class Phone {
    public void call () {

    }

    public void sendMsg () {

    }

    public void show () {
        System.out.println("number");
    }
}

// 需求：增加手机来电显示功能
// **不要在父类的show（）中进行修改
//   因为此父类可能拥有其他子类，修改父类会导致要修改其他子类，从而增加了工作量，而且降低了系统的维护性
// 正确做法:描述一个新的子类
class newPhone extends Phone {
    // 父类已经定义了show方法，子类可直接拿来用
    //但是子类对于功能的内容有自己的定义。保留父类功能的声明，建立子类功能特有的内容
    public void show () {
        //System.out.println("number");
        super.show();
        System.out.println("name");
        System.out.println("avanda");

    }
}

public class Main {

    public static void main (String[] args) {
        newPhone np = new newPhone();
        np.show();
    }

}