/*
需求：公司里有程序员，有姓名、工号、薪水、工作情况；
项目经理除了有姓名、工号、薪水、工作情况，还有奖金
对给出需求进行数据建模
 */

/*
分析：
程序员
    属性
    行为
项目经理：
    属性
    行为

两者不存在所属关系，但有共性内容，可以向上抽取
共性类型：雇员
    属性：姓名、工号、薪水
    行为：工作
 */
package day_09a_抽象类.b_练习;

abstract class Employee{
    private String name;
    private String id;
    private double pay;

    Employee(String name, String id, double pay){
        this.name = name;
        this.id = id;
        this.pay = pay;
    }

    //工作内容--不具体
    public abstract void work();
        }


class Developer extends Employee{
    Developer(String name, String id, double pay){
        super(name, id, pay);
    }

    public void work(){
        System.out.println("Code");
    }
}


class Manager extends Employee{
    private double bonus;

    Manager(String name, String id, double pay, double bonus) {
        super(name, id, pay);
        this.bonus = bonus;
    }

    public void work(){
        System.out.println("Manage");
    }
}


public class Main {
    public static void main(String[] args){
        Developer d = new Developer("Gary", "TECH_01", 7000.00);
        Manager m = new Manager("Lily", "MNG_01", 9000.00, 3000.00);
        d.work();
        m.work();
    }
}
