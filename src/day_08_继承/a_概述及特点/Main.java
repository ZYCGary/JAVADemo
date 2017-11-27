package day_08_继承.a_概述及特点;
//将Student 和 Worker 的共性代码抽取到一个共性的类型中
class Person{
	private String name; 
	//父类属性私有化，private仅是一个访问权限的标志，表示这个属性只能在父类内部访问
	//子类对象无法直接访问，但不代表子类中没有
	int age;
}

//描述Student
//让Student 和 Person 产生关系，就可以让student使用Person的共性内容
//通过关键字 extends

/* extends 特征：
 * 	1.提高了代码的复用性
 * 	2.让类与类之间产生了关系， 为第三个特征多态提供了前提
 * 
 * JAVA支持单继承，不直接支持多继承。（单继承：一个类只能有一个父类。）
 * 会出现调用的不确定性。
 * 
 * 多层次继承
 * 优点：产生继承体系
 * 		学习体系时，看顶层，了解基本功能
 * 		使用时，找最下面的对象
 * 什么时候定义继承？
 * 当事物之间存在所属关系（is a）时
 * 
 * 子类继承父类“所有”的属性和方法，不要为了取得某个方法而继承，
 * 所以要抽取方法到另一个类中，并让这个类成为他们的父类
 */
class Student extends Person{
	
	void study() {
		System.out.println("good good");
	}
}


class Worker extends Person{
	String name;
	int age;
	
	void work() {
		System.out.println("hard");
	}
}


public class Main {

	public static void main(String[] args) {
		Student s = new Student();
		
//		s.name = "Gary";   因为name为private
		s.age = 24;
		s.study();
	}

}
