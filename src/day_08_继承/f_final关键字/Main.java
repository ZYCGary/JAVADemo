package day_08_继承.f_final关键字;
/*
 * 继承覆盖缺点：打破封装性
 * 解决方法：final关键字，代表这个类不能有子类，不能被继承
 * 
 * final可以修饰类，方法，各种变量
 * final方法用法：父类中部分方法不可以被覆盖
 * 
 * final修饰的变量，是一个常量，只能赋值一次
 * 当使用的数据不变时，需要定义阅读性强的名称来表示数据，并将数据final化。
 * 被fianl修饰的变量名称规范：全大写，用 _ 分割单词
 */
class Parent{
	final void show() {
		//访问到了系统内容
	}
}

class Child extends Parent{
	public static final int NUM = 4;	//final的常量一般也会静态化,还可以成为全局常量（无需创建对象）
	
	void ppx() {
		final double PI = 3.14;	//定义常量
//		PI = 1.23;	//编译失败
		System.out.println(PI);
	}
}


public class Main{
	public static void main (String[] args) {
	}
}

//例子:单例模式
class Single{
	private static final Single SINGLE_INSTANCE = new Single();	//fianl用于固定SINGLE_INSTANCE
	//注意：懒汉式不能加final
	
	private Single() {
		
	}
	
	public static Single getInstance() {
		return SINGLE_INSTANCE;
	}
}

