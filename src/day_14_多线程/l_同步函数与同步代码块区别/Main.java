package day_14_多线程.l_同步函数与同步代码块区别;

/*
同步代码块可以使用任意的对象作为锁
同步函数只能使用this作为锁

如果说一个类中只需要一个锁，这时可以考虑同步函数，使用this，写法简单
但是，一个类中如果需要多个锁，或者多个类中使用同一个锁，这时只能使用同步代码块

所以开发时建议使用同步代码块
 */

public class Main {
}
