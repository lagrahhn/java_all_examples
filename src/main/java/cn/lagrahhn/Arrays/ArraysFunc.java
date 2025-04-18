package cn.lagrahhn.Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class ArraysFunc {

    /**
     * 打印数组
     */
    public void printArrays() {
        String[] arr = new String[]{"a", "b", "c"};
        System.out.println("输出全部的数组内容为：" + Arrays.toString(arr));
    }

    /**
     * 复制全部的数组
     */
    public void copyFullArrays() {
        String[] arr = new String[]{"a", "b", "c"};
        String[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.printf("输出的被复制数组内容为：%s \n输出的复制数组内容为： %s", Arrays.toString(arr), Arrays.toString(arr2));
    }

    /**
     * 复制部分数组,use copyOfRange
     */
    public void copyPartArrays1() {
        String[] arr = new String[]{"a", "b", "c"};
        String[] arr2 = Arrays.copyOfRange(arr, 0, 2);
        System.out.printf("输出的被复制数组内容为：%s \n使用copyOfRange(arr,0,2)输出的部分复制数组内容为： %s", Arrays.toString(arr), Arrays.toString(arr2));
    }

    /**
     * 复制部分数组,use copyOf
     */
    public void copyPartArrays2() {
        String[] arr = new String[]{"a", "b", "c"};
        String[] arr2 = Arrays.copyOf(arr, 2);
        System.out.printf("输出的被复制数组内容为：%s \n使用copyOf(arr,2)输出的部分复制数组内容为： %s", Arrays.toString(arr), Arrays.toString(arr2));
    }

    /**
     * 复制部分数组,use copyOf，newLength超过的部分用null填充
     */
    public void copyPartArrays3() {
        String[] arr = new String[]{"a", "b", "c"};
        String[] arr2 = Arrays.copyOf(arr, 10);
        System.out.printf("输出的被复制数组内容为：%s \n使用copyOf(arr,10)输出的部分复制数组内容为,多余的部分用null填充： %s", Arrays.toString(arr), Arrays.toString(arr2));
    }

    /**
     * 填充数组,use Arrays.fill
     */
    public void fillArrays1() {
        String[] arr = new String[10];
        Arrays.fill(arr, "java");
        System.out.println("使用Arrays.fill(arr,\"java\")填充数组后的内容为：" + Arrays.toString(arr));
    }

    /**
     * 填充数组,use Arrays.setAll,setAll 需要传入一个函数，用于生成填充值
     */
    public void fillArrays2() {
        Integer[] arr = new Integer[10];
        IntFunction<Integer> integerIntFunction = i -> new Random().nextInt(100);
        Arrays.setAll(arr, integerIntFunction);
        System.out.println("使用Arrays.setAll(arr, integerIntFunction)填充数组后的内容为：" + Arrays.toString(arr));
    }

    /**
     * 比较数组,use Arrays.equals,一维数组比较没有问题
     */
    public void compareArrays1() {
        String[] arr = new String[]{"a", "b", "c"};
        String[] arr2 = new String[]{"a", "b", "c"};
        System.out.println("使用Arrays.equals(arr,arr2)比较数组后的内容为：" + Arrays.equals(arr, arr2));
    }

    /**
     * 比较数组,use Arrays.deepEquals,高维数组比较用deepEquals进行比较
     */
    public void compareArrays2() {
        String[][] arr = new String[][]{{"a", "b", "c"}, {"a", "b", "c"}};
        String[][] arr2 = new String[][]{{"a", "b", "c"}, {"a", "b", "c"}};
        System.out.println("使用Arrays.equals(arr,arr2)比较二维数组后的内容为：" + Arrays.equals(arr, arr2));
        System.out.println("使用Arrays.deepEquals(arr,arr2)比较二维数组后的内容为: " + Arrays.deepEquals(arr, arr2));
    }

    /**
     * 比较数组,use Arrays.hashCode和Arrays.deepHashCode,高维数组比较用deepHashCode进行比较
     */
    public void compareArrays3() {
        String[] arr = new String[]{"a", "b", "c"};
        Object[] arr2 = new Object[]{arr, arr};
        System.out.println(Arrays.hashCode(arr2));
        System.out.println(Arrays.deepHashCode(arr2));
        arr[0] = null;
        System.out.println(Arrays.hashCode(arr2));
        System.out.println(Arrays.deepHashCode(arr2));
    }

    /**
     * 排序数组,use Arrays.sort,升序排序
     */
    public void sortArrays() {
        Integer[] arr = new Integer[]{1, 3, 2};
        System.out.printf("使用Arrays.sort(arr)排序前的内容为：%s\n", Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.printf("使用Arrays.sort(arr)排序后的内容为：%s", Arrays.toString(arr));
    }

    /**
     * 二分查找数组,use Arrays.binarySearch
     */
    public void binarySearchArrays() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = Arrays.binarySearch(arr, 5);
        System.out.println("查询的数组为" + Arrays.toString(arr));
        System.out.println("元素所在位置" + index);
        System.out.println("元素为" + arr[index]);
    }

    /**
     * 数组转List,use Arrays.asList,转换后的list无法支持增加和删除,和原始数组共享数据
     */
    public void arrays2List() {
        String[] arr = new String[]{"a", "b", "c"};
        List<String> list = Arrays.asList(arr);
        System.out.println("转换前" + Arrays.toString(arr) + "\n转换后" + list);
        System.out.println("转换后的list无法支持增加和删除,和原始数组共享数据");
    }

}
