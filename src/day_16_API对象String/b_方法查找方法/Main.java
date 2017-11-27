package day_16_API对象String.b_方法查找方法;

public class Main {
    public static void main (String[] args) {

        /*
        "abcd"

        String可以见字节数组和字符数组构造成字符串
         */

        String str = "abcda";

        // 获取长度
        int len = str.length();

        // 获取指定位置的字符
        char ch = str.charAt(0);

        // 获取指定字符的位置
        int index = str.indexOf('a');
        int lastIndex = str.lastIndexOf('a');

        // 指定的字符串在原字符串中是否出现以及出现的位置
        int strIndex = str.indexOf("ab");

        // 分解字符串为多个字符
        char[] ch1 = str.toCharArray();

        // 字符串是否以指定的字符串开头／结尾，是否包含指定字符串
        boolean start = str.startsWith("ab");
        boolean end = str.endsWith("ab");
        boolean con = str.contains("ab");

        // 获取字符串的一部分（子串）
        String sub = str.substring(1, 3);
        String sub1 = str.substring(1);

        // 将字符串的指定字符修改为另一个字符
        String rep = str.replace('a', 'k');

        // 字符串可以比较大小吗？如果有，将字符串排序
        /*
        基本类型数值可以通过比较运算符比较大小／相等
        对象也可以比较大小／相等，都是通过方法完成的
        相同：boolean Object.equals()(子类一般都会复写，建立自己判断依据)
        大小：该功能有三种情况（大、小、相等）所以使用int类型
             大于返回正数；小于后者返回负数；等于返回0
             compareTo(String anotherString)
         */

        String[] strs = {"nba", "haha", "qq", "wechat"};
        sort(strs);
        printArray(strs);
    }

    public static void sort (String[] strs) {
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[i].compareTo(strs[j]) > 0) {
                    switchIndex(strs, i, j);
                }
            }
        }
    }

    public static void switchIndex (String[] strs, int i, int j) {
        String temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }

    public static void printArray (String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            if (i != strs.length - 1)
                System.out.println(strs[i] + ", ");
            else
                System.out.println(strs[i]);
        }
    }
}
