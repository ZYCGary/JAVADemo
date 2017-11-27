package day_12_包.a_包之间的访问.mypack;

public class Main {
    public static void main (String[] args) {
        day_12_包.a_包之间的访问.packa.DemoA d = new day_12_包.a_包之间的访问.packa.DemoA();
        d.show();
        System.out.println("Hello mypack!");
    }
}

/*
问题1：DemoA d1 = new DemoA();
Error:(5, 9) java: cannot find symbol
  symbol:   class DemoA
  location: class day_12_包.b_包之间的继承.mypack.Main
原因：类名写错
解决：有了包以后，类名应该是：包名.类名


问题2：
原因：如果packa包没有在同一个文件夹。需要告诉jvm他的位置
解决：设置PATH

问题3：
Error:(5, 32) java: day_12_包.b_包之间的继承.packa.DemoA is not public in day_12_包.b_包之间的继承.packa; cannot be accessed from outside package
原因：被访问的保重的类DemoA，权限不够
就觉：用public修饰

问题4：
Error:(6, 10) java: show() is not public in day_12_包.b_包之间的继承.packa.DemoA; cannot be accessed from outside package
原因：DemoA.show()访问权限不足
解决：用public修饰
*/
