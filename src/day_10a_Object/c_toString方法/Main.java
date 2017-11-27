package day_10a_Object.c_toString方法;

class Person{
    private int age;
    private String name;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    /**
     * 建立Person对象所有的字符串表达式，只要覆盖toString方法jike
     */
    public String toString() {
        return "Person[name = "+this.name+", age = "+this.age+"]";
    }
}


public class Main {

    public static void main(String[] args) {
        Person p1 = new Person("Gary", 24);
        System.out.println(p1); //Person@3cd1a2f1 数据类型@哈希值
        System.out.println(p1.toString());  //和上一句等价，但是看着不爽！建议所以子类都重写toString
    }
}

