package day_13_面向对象练习题.exercise_4;

/**
 * 描述Person
 * 属性：姓名，年龄
 * 行为：
 *      1，说出姓名和年龄
 *      2，判断是否是同一个人（同名同年龄）
 * 提示：判断相同的方法在API的String 类中
 */


class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void speak(){
        System.out.println(this.name + "...." + this.age);
    }

    /**
     * 既然要判断对象是否相同，直接使用Object方法
     * 但是还要依据子类的特征，所以覆盖方法
     */
    public boolean equals(Object obj){

        //判断姓名、年龄是否相同，这些都是Person的属性，所以向下转型
        if(!(obj instanceof Person))
            throw new ClassCastException();

        Person p = (Person) obj;

        return this.age == p.age && this.name.equals(p.name);
    }
}

public class Main {

    public static void main (String[] args) {

    }
}
