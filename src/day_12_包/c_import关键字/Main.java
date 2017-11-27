package day_12_包.c_import关键字;

import day_12_包.b_包之间的继承.packfu.*;  //简化类名书写
// * 是通配符，导入该类所有的内容
// 为了提高效率，一般不要用 *
// import导入的是class，不是包，如果要导入子包中的class：包.子包.类名

//当不同包中的类重名了，这时即使导入了，在使用时也必须明确该类的包名
public class Main {
}
