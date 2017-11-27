package day_11_异常.e_练习;

/*
异常：就是将问题封装成对象，并抛给调用者
    如果声明了就需要调用者处理（继续声明 or 捕获）

    什么时候声明？什么时候捕获呢？
        功能内部可以解决就捕获，
        不能解决或就绝了还必须告诉调用者问题就应该声明
 */

/*
练习：王老师用电脑上课
异常：电脑蓝屏，电脑冒烟
需要对问题进行描述
 */

/**
 * 蓝屏异常，是可处理的
 */
class LanPingException extends Exception{
    LanPingException(){
    }

    LanPingException(String message){
        super(message);
    }
}

/**
 * 冒烟异常，是可处理的
 */
class MaoYanException extends Exception{
    MaoYanException(){
    }

    MaoYanException(String message){
        super(message);
    }
}


/**
 *  电脑冒烟导致的是老师计划无法进行
 *  应抛出面向老师的异常
 */
class NotPlanException extends Exception{
    NotPlanException(){
    }

    NotPlanException(String message){
        super(message);
    }
}


class Computer{

    //定义电脑状态
    private int state = 2;

    public void run() throws LanPingException, MaoYanException{
        if(state == 1)
            throw new LanPingException("蓝屏了");
        if(state == 2)
            throw new MaoYanException("冒烟了");
        System.out.println("comp run");
    }

    public void reset(){
        System.out.println("电脑重启");
        state = 0;
    }

}


class Teacher{
    private String name;
    private Computer comp;

    Teacher(String name){
        this.name = name;
    }

    public void lecture(Computer comp) throws NotPlanException{

        try{
            comp.run();
            System.out.println("上课");
        }

        catch (LanPingException e){
            System.out.println(e.toString());
            comp.reset();
            //继续讲课
            lecture(comp);
        }

        //封装本层异常，对外暴露调用者可处理的异常
        catch (MaoYanException e){
            test();
            throw new NotPlanException("课时进度停止");    //电脑冒烟导致的是老师计划无法进行，应抛出面向老师的异常
        }
    }

    public void test(){
        System.out.println("大家做练习");
    }
}


public class Main {

    public static void main(String[] args) {
        Teacher t = new Teacher("Wong");
        Computer comp1 = new Computer();

        //对抛出的"电脑"冒烟异常进行处理
        try{
            t.lecture(comp1);
        }
        catch (NotPlanException e){
            System.out.println("改课时");
        }
    }
}
