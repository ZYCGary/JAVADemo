package day_09c_多态.e_练习;

/*
练习：
阶段一：
笔记本电脑：运行

阶段二：
想使用一个鼠标（新增功能：使用鼠标，并多了一个鼠标对象）

阶段三：
每多一个功能就需要在笔记本对象中定义一个函数，不爽！拓展性差！
降低鼠标、键盘等外设和笔记本电脑的耦合性
 */

//阶段一
//描述笔记本电脑
//class Notebook{
//    public void run(){
//        System.out.println("run");
//    }
//}
//
//public class Demo1 {
//    public static void main(String[] args) {
//        Notebook nbook = new Notebook();
//        nbook.run();
//    }
//}

//阶段二
//class Notebook{
//    public void run(){
//
//    }
//
//    //鼠标不确定，定义参数
//    public void useMouse(Mouse m){
//        //判断一下，m必须指向鼠标对象才可以调用
//        if(m != null){
//            m.open();
//            m.close();
//        }
//    }
//}
//
////描述鼠标
//class Mouse{
//    public void open(){
//        System.out.println("open");
//    }
//
//    public void close(){
//        System.out.println("close");
//    }
//}
//
//
//public class Demo1{
//    public static void main(String[] args) {
//        Notebook nb = new Notebook();
//        Mouse m = new Mouse();
//        nb.run();
//        nb.useMouse(m);
//    }
//}


//阶段三：如果还想使用其他外设？
//可以在笔记本对象中继续定义useKey()等方法
//但是这样没正价一个设备都需要不断改动笔记本中的内容，扩展性差、维护性差
//怎么办？--后期的设备不确定，每多一个设备就多加了一个功能，说明设备和笔记本耦合性太强
//所以不需要每次都去面对具体的类型，只要定义一个规则，让后期的设备都符合这个规则，这样面对规则就可以
//所以定义接口就可以

//1，先定义规则

/**
 * 定义USB接口
 */
interface USB{

    /**
     *设备开启
     */
    public void open();

    /**
     *设备关闭
     */
    public void close();
}


class Notebook{

    /**
     * 运行
     */
    public void run(){
        System.out.println("run");
    }

    /**
     * 使用符合规则的外设
     */
    public void useUSB(USB usb){    //定义了一个接口的引用
        if(usb != null){
            usb.open();
            usb.close();
        }
    }
}


//想要换个鼠标，只要买一个符合规则的鼠标，笔记本就能用
class MouseByUSB implements USB{
    public void open(){
        System.out.println("mouse open");
    }

    public void close(){
        System.out.println("mouse close");
    }
}


//想要键盘
class Keyboard implements USB{
    public void open(){
        System.out.println("key open");
    }

    public void close(){
        System.out.println("key close");
    }
}
class Demo2{
    public static void main(String[] args) {
        Notebook nb = new Notebook();
        nb.run();
        nb.useUSB(null);
        nb.useUSB(new MouseByUSB());    //USB usb = new MouseByUSB()  多态，提高了笔记本的扩展性
        nb.useUSB(new Keyboard());
    }
}

