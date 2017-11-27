package day_13_面向对象练习题.exercise_2;

/**
 * 在一个类中编写一个方法，这个方法搜索一个字符数组中是否存在某个字符，
 * 如果存在，则返回这个字符所在字符数组中第一次出现的位置（序列号从0开始计算），
 * 否则返回-1。
 * 要搜索的字符数组和字符都以参数形式传递传播给该方法，
 * 如果传入数组为null，应抛出IllegalArgumentException异常。
 * 主类的main方法中以各种可能出香的情况测试验证该方法编写的正确性。
 */

/**
 * 定义方法类
 */
class Method{

    /**
     * 定义搜索字符方法
     * @param chs 输入的字符数组
     * @param key 搜索的字符
     * @return 字符第一次出现的位置
     */
    public int searchChar(char[] chs, char key) {

        // 判断字符数组是否为空
        if(chs == null)
            throw new IllegalArgumentException("数组为空");

        // 逐个字符搜索字符数组
        for (int i = 0; i < chs.length; i++) {
            if (key == chs[i])
                return i;
        }

        return -1;
    }
}

/**
 * 定义主类,用于测试Method类方法searchChar()
 */
public class Main {

    public static void main (String[] args) {

        Method method = new Method();

        /**
         * 情况1；输入数组不为null，且包含要搜索的字符
         */
        char[] chars = {'G','a','r','y'};
        System.out.println(method.searchChar(chars,'a'));

        /**
         * 情况2：输入数组不为null，不包含要搜索的字符
         */
        System.out.println(method.searchChar(chars,'h'));

        /**
         * 情况3：输入数组为null
         */
        char[] chars1 = null;
        System.out.println(method.searchChar(chars1,'a'));
    }
}
