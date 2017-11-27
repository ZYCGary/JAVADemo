package day_13_面向对象练习题.exercise_3;

/**
 * 创建一个由三个圆形对象组成的数组，创建一个compare方法比较他们的半径，
 * 要求输入是圆形对象的数组，返回最大的半径值
 */

/**
 * 创建圆形类
 */
class Circle{
    private double radius;

    /**
     * 创建构造函数
     * @param radius 圆的半径
     */
    public Circle(double radius){
        this.radius = radius;
    }

    /**
     * 从圆形对象数组中找出最大半径的值
     * @param circles 圆形对象数组
     * @return 最大半径值
     */
    public static double compare(Circle[] circles){
        double max = circles[0].radius;

        for(int i = 1; i < circles.length; i ++){
            if(circles[i].radius > max)
                max = circles[i].radius;
        }

        return max;
    }
}

public class Main {

    public static void main (String[] args) {
        Circle cir[] = new Circle[3];
        cir[0] = new Circle(1.0);
        cir[1] = new Circle(2.0);
        cir[2] = new Circle(4.0);
        System.out.println("最大的半径值是： " + Circle.compare(cir));
    }
}
