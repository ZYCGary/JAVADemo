package day_10a_Object.b_equals方法;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

class Person extends Object{
    private int age;
    private  String name;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    //定义一个方法，判断两个person对下岗是否是同一个人，判断依据是年龄是否相同
    //不用在自定义方法判断对象是否相同，因为Object父类中已经定义了这样的方法，直接使用就可以，
    //但是判断的内容是根据Person的特点定义的。
    //需要保留父类的功能声明，定义子类功能的特有内容 -- 覆盖
    public boolean equals(Object obj){    //相当于Object obj = new Person();
        //提高点效率,如果两个引用指向同一个对象，不用再转换并比较内容，直接比较地址就ok了
        if(this == obj)
            return true;

        // obj.age 是错误的，因为Object中无age。
        // 想要使用子类对象特有的属性或行为,必须向下转型，需要进行类型判断
        if(!(obj instanceof Person))
            throw new ClassCastException("类型错误");

        Person p = (Person)obj;
        // 如果判断字符串，不要用 == ，因为字符串String本身是一个对象,所以要使用String类的equals方法判断。
        return this.name.equals(p.name) && this.age == p.age;
    }
}

class Dog{

}

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Gary", 24);
        Person p2 = new Person("Gary", 22);
//        Person p3 = p1;

        System.out.println(p1.equals(p2));  //判断的是对象的内容，用equals
        System.out.println(p1 == p2);   //判断的是对象的地址
//        System.out.println(p1.equals(p3));
//        System.out.println(p1.equals(new Dog()));
        System.out.println(p1.equals(p1));
    }
}

