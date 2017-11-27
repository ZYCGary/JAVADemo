package day_13_面向对象练习题.exercise_1;
/**
 * 建立一个接口，声明一个面积函数。圆形和矩形都实现这个接口，并得出两个图形的面积
 * 注：体现面向对象的特征，对数值进行判断，用异常处理。不合法数值要出现"这个数值时非法的"提示，不再进行运算
 */


/**
 * 定义数值非法异常
 */
class NotValueException extends RuntimeException{    //这个异常是不需要被处理的，所以继承RuntimeException

    NotValueException(String message){
        super(message);
    }
}

/**
 * 定义计算面积的接口
 */
interface calculate{

    double getArea();
}

/**
 * 定义长方形类
 */
class Rectangle implements calculate{
    private int length, width;

    public Rectangle(int length, int width){
        if (length <= 0 || width <= 0)
            throw new NotValueException("这个数值是非法的");
        this.length = length;
        this.width = width;
    }

    public double getArea(){
        return length * width;
    }
}

/**
 * 定义圆形类
 */
class Circle implements calculate{
    private int radius;
    private static double PI = 3.14;

    public Circle(int radius){
        if (radius <= 0)
            throw new NotValueException("这个数值是非法的");
        this.radius = radius;
    }

    public double getArea(){
        return PI * radius * radius;
    }
}

/**
 * 主方法
 */
public class Main {

    public static void main (String[] args) {
        Rectangle r = new Rectangle(3, 4);
        Circle c = new Circle(3);

        System.out.println(r.getArea());
        System.out.println(c.getArea());
    }

}
