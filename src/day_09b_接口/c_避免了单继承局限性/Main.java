package day_09b_接口.c_避免了单继承局限性;


class Fu{
    void show(){
        System.out.println("fu show");
    }
}


interface Inter1{
    void show1();
}

/*因为继承，Zi具备了该体系的基本功能
现在如果想扩展一些功能，具备show1（）功能
一个类继承一个类的同时，还可以实现多个接口，可以通过接口扩展功能
避免了单继承的局限性

继承是为了获取体系的基本功能，
想要扩展功能，可以通过实现接口类实现
*/

class Zi extends Fu implements Inter1{
    public void method(){
        System.out.println("zi method");
    }

    public void show1(){
        System.out.println("zi show1");
    }
}


public class Main {

    public static void main(String[] args) {
        Zi z = new Zi();
        z.show();
        z.method();
        z.show1();
    }
}
