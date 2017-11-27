package day_09c_多态.f_练习;

class Fu{
    int num = 5;
    void show()
    {
        System.out.println("num= " + this.num);
    }
}

class Zi extends Fu{
    int num = 6;
}


public class Main {
    public static void main(String[] args) {
        Fu f = new Zi();
        f.show();
    }
}

