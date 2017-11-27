package day_14_多线程.c_单线程的问题;

class Demo{
    private String name;

    Demo(String name){
        this.name = name;
    }
    public void show(){
        for(int i = 1; i <= 10; i ++){
            System.out.println(name + "..." +i);
        }
    }
}

public class Main {
    public static void main (String[] args) {
        Demo d1 = new Demo("Gary");
        Demo d2 = new Demo("Lily");
        d1.show();
        d2.show();
    }
}
