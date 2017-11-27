package day_09c_多态.f_多态中成员变量的调用;

/*
多态中对成员的调用

1，成员变量：当子父类出现同名成员变量时
    多态调用时，只看调用该成员变量的引用所属的类中的成员变量（看 = 左边就ok）
2，成员函数：出现相同函数时
    编译时，看的是引用变量所属的类中的方法（= 左边）
    运行时，看的是对象说属的类中的方法（= 右边）

    成员方法动态绑定到当前对象上
3，静态函数；出现相同的静态函数
    静态函数所属于的是类，与对象无关，属于哪个类就返回哪个静态函数（看 = 左边）
    真正调用静态方法是不需要对象的，直接类名调用。因为静态方法绑定到类上。
 */

class Fu{
    int num = 4;

    void show(){
        System.out.println("fu show");
    }

    static void method(){
        System.out.println("fu static method");
    }
}


class Zi extends Fu{
    int num = 6;

    void show(){
        System.out.println("zi show");
    }

    static void method(){
        System.out.println("zi static method");
    }
}


public class Main {
    public static void main(String[] args) {
//        Fu f = new Zi();
//        System.out.println(f.num);

//        Fu f = new Zi();
//        f.show();

        Fu f = new Zi();
        f.method();
    }
}

