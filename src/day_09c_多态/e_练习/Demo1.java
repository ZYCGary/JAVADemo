package day_09c_多态.e_练习;

/*
练习：
父亲：讲课，钓鱼
儿子：讲课，看电影
 */
//描述父亲
class Father{
    public void teach(){
        System.out.println("C");
    }

    public void fishing(){
        System.out.println("钓鱼");
    }
}

//描述儿子
class Son extends Father{
    public void teach(){
        System.out.println("java");
    }
    public void watch(){
        System.out.println("看电影");
    }
}


public class Demo1 {
    public static void main(String[] args) {
        //多态的形式
        Father a = new Son();   //向上转型
        a.teach();  //已被子类的teacher（）覆盖
        a.fishing();

        //要想使用Son的特有方法 watch()
        Son b = (Son)a; //向下转型
        b.watch();
        b.fishing();

        //转型过程中，自始至终只有子类对象在做类型的变换，只有一个Son对象，而不是两个Son对象。
    }
}

