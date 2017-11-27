package day_11_异常.d_自定义异常;

//定义一个功能，可以实现出发运算，但是除数不能为负数

/**
 * 将负数为除数的问题进行描述
 */
class FuShuException extends RuntimeException{
    FuShuException(){
        super();
    }

    FuShuException(String message){
        super(message);
    }
}


class Demo {
    int div (int a, int b) {

        if (b == 0)
            throw new ArithmeticException("divided by zero");

        if (b < 0)
            throw new FuShuException("负数不可以作为除数");

        return a / b;
    }
}


public class Main {

    public static void main (String[] args) {
        Demo d = new Demo();
        System.out.println(d.div(4, -2));
    }
}
