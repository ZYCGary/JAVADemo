package day_12_包.b_包之间的继承.run;

import day_12_包.b_包之间的继承.packfu.DemoFu;
import day_12_包.b_包之间的继承.packzi.DemoZi;

public class Main {
    public static void main (String[] args) {
        DemoZi zi = new DemoZi();
        zi.show();

        DemoFu fu = new DemoFu();
        //fu.method();
        //问题：DemoFu 是public，所以只要创建DemoFu的对象就能创建Method(),DemoZi就没有意义了
        //解决：用protected 修饰父类DemoFu.method()，保证method()只能被继承了DemoFu的类访问
    }
}

/*
总结：访问权限
            public      protected       default     private
同一个类中     *             *               *           ok
同一个包中     *             *               *
子类          *             *
不同包中       *

包与包之间只有public和protected
其中protected只有子类能用
*/
