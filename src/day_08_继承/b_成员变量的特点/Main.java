package day_08_继承.b_成员变量的特点;
/*
 * 子父类出现后，代码上的一些特点：
 * 	1. 成员变量
 * 	2. 成员函数
 * 	3. 构造函数
 */

//1. 成员变量（注意的仅是原理，书写很少见）
class Fu{
	int num = 4;
}

class Zi extends Fu{
	int num = 5;
	void show() {
		int num = 6;
		System.out.println("num1 = " + num);
		System.out.println("num2 = " + this.num); //本类中成员变量和局部变量同名
		System.out.println("num3 = " + super.num);//子父类中出现了同名成员变量
//super和this用法相似：
//this： 代表本类的对象引用
//super： 代表父类的那篇空间，而不是对象的引用。 super后边必须有 . 或者 ()
	}
}
public class Main {

	public static void main(String[] args) {
		Zi z = new Zi();
		z.show();

	}

}
