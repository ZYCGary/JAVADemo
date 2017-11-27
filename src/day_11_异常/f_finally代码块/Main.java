package day_11_异常.f_finally代码块;

/*
finally作用：无论是否有异常发生，都要对资源进行释放
    资源释放动嘴就定义在finally代码块中
 */
public class Main {
    public static void main (String[] args) {
        try{
            int num = 4/0;
            System.out.println("num = " + num);
        }

        catch (Exception e){
            System.out.println(e.toString());
//            return;
            System.exit(0); //推出jvm，只有这种情况，finally也不执行。
        }

        finally {
            System.out.println("finally");
        }

        System.out.println("over");
    }
}
