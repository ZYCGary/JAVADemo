package day_08_继承.e_子类实例化过程_练习;
//进行代码的复用
class Person1{
	private String name;
	private int age;
	
	Person1(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
}

class Student1 extends Person1{
	// 可直接调用Person的构造函数
	Student1(String name, int age){
		super(name, age);
	}
	
	void study() {
		System.out.println("study");
	}
}

class Worker1 extends Person1{
	Worker1(String name, int age){
		super(name, age);
	}
	
	void work() {
		System.out.println("work");
	}
}

public class Main {
	public static void main(String[] args) {
		Student1 s = new Student1("Gary", 24);
		Worker1 w = new Worker1("Yuchen", 23);
		
		s.getName();
		w.getName();
	}
}
