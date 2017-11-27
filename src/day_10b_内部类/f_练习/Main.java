package day_10b_内部类.f_练习;

class Outer {
    public void method () {
        new Object() {
            public void show () {
                System.out.println("show run");
            }
        }.show();

        Object obj = new Object() {    //Object obj指向了自己的子类对象，对象提升为object，就不能调用子类的特有方法。
            public void show () {
                System.out.println("show run");
            }
        };

    }
}

    public class Main {

        public static void main(String[] args) {
            System.out.println("Hello World!");
        }
    }
