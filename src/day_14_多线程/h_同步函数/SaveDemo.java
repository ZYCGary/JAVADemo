package day_14_多线程.h_同步函数;

class Bank1{
    private String name;
    private int sum;

    protected Bank1(String name){
        this.name = name;
    }

    public synchronized void add(int n){
        sum = sum + n;
        System.out.println(name + " sum = " + sum);
    }
}

class Customer1 implements Runnable{
    Thread save = new Thread(this); //每一个Customer的存钱行为都是一个单独的线程
    Bank1 b;    //每个Customer都要把钱存到一个银行中去

    /**
     * 明确要去那个银行存钱
     * @param bank1
     */
    public void where(Bank1 bank1){
        this.b = bank1;
    }

    public void run() {
        saveCash(b);
    }

    /**
     * 存钱函数：以共存3次，每次存100
     * @param b 目标银行
     */
    public void saveCash(Bank1 b){
        for (int i = 0; i < 3; i ++){
            b.add(100);
        }
    }
}

public class SaveDemo {
    public static void main (String[] args) {

        Bank1 b1 = new Bank1("ICBC");
        Bank1 b2 = new Bank1("BOC");
        Customer1 c1 = new Customer1();
        Customer1 c2 = new Customer1();
        Customer1 c3 = new Customer1();

        c1.where(b1);
        c2.where(b2);
        c3.where(b1);

        c1.save.start();
        c2.save.start();
        c3.save.start();
    }
}

