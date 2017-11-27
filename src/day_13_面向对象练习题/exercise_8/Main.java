package day_13_面向对象练习题.exercise_8;

/**
 * 写出下面代码的执行结果
 */

import java.io.IOException;

public class Main {
    public static void main (String[] args) {
        try{
            new Main().methodA(5);
        }
        catch (IOException e){
            System.out.println("caught IOException");
        }
        catch (Exception e){
            System.out.println("caught Exception");
        }
        finally {
            System.out.println("no Exception");
        }
    }

    void methodA(int i) throws IOException{
        if (i % 2 != 0)
            throw new IOException("methodA IOException");
    }
}
