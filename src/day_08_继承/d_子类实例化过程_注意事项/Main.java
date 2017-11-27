package day_08_继承.d_子类实例化过程_注意事项;
/*
 * 父类中构造函数的特点
 * 
 * 发现：创建子类对象是，父类中的空参数构造函数也运行了。Why？
 * 因为子诶中所有的构造函数的第一行默认都有一个隐式的super()语句。（默认访问父类的“空参数”构造函数）
 * 
 * 调用本类中的构造函数用this，调用父类的构造函数用super
 * 注意：当父类中没有空参数构造函数时，子类要通过显试定义super来访问父类的含参数构造函数，且必须定义在第一句
 * 为什么子类对象初始化要访问父类的构造函数呢？
 * 因为子类继承了父类的内容，所以创建对象时必须要先看父类是如何初始化的
 * 
 * 
 * 问题：
 * 1. super和this用于调用构造函数可以共同存在吗？
 * No，他们只能存在与第一行。
 * 2. 为什么需要定义在第一行？
 * 因为初始化要先执行。
 */
class Fu1{
	Fu1(){
		System.out.println("fu run");	
	}
	
	Fu1(int x){
		System.out.println("du run..." + x);
	}
}

class Zi1 extends Fu1{
	Zi1(){
//		super();  隐式的super()
//		super(4);	//显式指令访问父类构造函数
		this(5);		//this，super都要写在第一行，有this就没有super了，但是他可以通过另一个构造函数调用父类构造函数
		System.out.println("zi run");
	}
	
	Zi1(int x){
		super(x);
		System.out.println("zi run..." + x);
	}
}
public class Main {

	public static void main(String[] args) {
		Zi1 z1 = new Zi1();
		Zi1 z2 = new Zi1(5);

	}

}
