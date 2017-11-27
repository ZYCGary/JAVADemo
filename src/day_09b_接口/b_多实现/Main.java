package day_09b_接口.b_多实现;

//多继承 优点：可以让子类具备更多功能。   缺点：调用不确定性 （eg.两个父类里都有show()），原因在于方法主体内容不同
//Java中不直接支持多继承，而是通过接口来解决，转换为了多实现


interface InterA{
    void show();
}


interface InterB{
    void show();
}


class SubInter implements InterA, InterB{   //多实现
    public void show(){
        System.out.println("Inter show");
    }
}


public class Main {

    public static void main(String[] args) {
        SubInter inter = new SubInter();
        inter.show();
    }
}
