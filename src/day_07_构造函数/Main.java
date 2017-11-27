package day_07_构造函数;

class Person {
	private String name;
	private int age;
	
	Person()
	{
		name = "Gary";
	}
	
	private Person(String n)
	{
		name = n;
	}
	/*
	 * 构造函数私有，只在本类中有效，该如何访问？
	 * 如何调用private 的构造函数？
	 * 通过关键字 this 调用：this代表的是对象（那个正在调用this的那个对象）。
	 * this 带上参数列表的方式就可以访问本类中的其他函数
	 * this 必须放在构造函数第一行
	 * 一个构造函数只能出现一个 this， 构造函数出现相互调用就会递归溢出
	 */
	
	Person(String n, int a)
	{
		this(n); //访问 Person(String n)
//		name = n;
		age = a;
	}
}


public class Main{
	public static void main (String[] args) {
		Person p = new Person("Gary", 24);
	}
}
