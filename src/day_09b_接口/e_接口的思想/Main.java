package day_09b_接口.e_接口的思想;

/*
接口的思想:凡事对外提供的都可以叫做接口，对外的必须是public
笔记本电脑的USB接口：
1，接口的出现扩展了功能
2，接口其实就是暴露出来的规则（规范化）
3，接口的出现降低了耦合性（解耦）
*/

class Mouse{
}

interface USB{
}

class NewMouse extends Mouse implements USB{
}

/*
接口的出现：一方使用接口，一方在实现接口。
好处：不再需要面向未来可能出现的新对象，只需要关注接口即可
 */
public class Main {
}
