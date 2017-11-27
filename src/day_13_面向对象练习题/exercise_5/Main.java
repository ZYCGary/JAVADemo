package day_13_面向对象练习题.exercise_5;

class Circle{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    /**
     * 请定义一个佛你功能：比较两个圆圈是否一样大。
     */
    public boolean equals(Object obj){
        if(!(obj instanceof Circle))
            throw new ClassCastException(obj.getClass().getName() + "类型错误");

        Circle c = (Circle)obj;

        return c.radius == this.radius;
    }
}

public class Main {

    public static void main (String[] args) {
        Circle cir1 = new Circle(2.0);
        Circle cir2 = new Circle(2.0);

        boolean b = cir1.equals(cir2);
        System.out.println("两个圆是否一样大： " + b);
    }
}
