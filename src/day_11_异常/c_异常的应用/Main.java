package day_11_异常.c_异常的应用;

//定义一个功能，返回一个整数型数组中指定未知的元素

public class Main {

    public static int getElement(int[] arr, int index){
        if (index >= arr.length || index < 0)
            throw new ArrayIndexOutOfBoundsException(index + ",角标不存在"); //内部有抛出，外部不声明，让调用者知道问题所在

        if(arr == null)
            throw new NullPointerException("数组实体不存在");

        int element = arr[index];
        return element;
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        getElement(array, 99);

    }
}

