package cn.lagrahhn.java8.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class StreamFunc {

    int[] arr = {4, 12, 1, 3, 5, 7, 9};

    /**
     * filter过滤保存数组中的数，仅保留奇数
     */
    public void filter() {
        System.out.println("原字符串数组:" + Arrays.toString(arr));
        Arrays.stream(arr).filter(s -> s % 2 != 0).forEach(x -> System.out.print(x + ","));
    }

    /**
     * map对每个数进行操作
     */
    public void map() {
        System.out.println("原字符串数组:" + Arrays.toString(arr));
        Arrays.stream(arr).map((x) -> x * x).forEach(x -> System.out.print(x + ","));
    }

    /**
     * reduce,x+y将当前元素与下一个元素相加，相当于求和
     * ifPresent检查是否为空，不为空则输出
     */
    public void reduce() {
        System.out.println("原字符串数组:" + Arrays.toString(arr));
        Arrays.stream(arr).reduce((x, y) -> x + y).ifPresent(System.out::println);
        System.out.println(Arrays.stream(arr).reduce(-10, (x, y) -> x + y));
    }

    /**
     * collect,将数组转化为list和set
     * Collectors.toSet 将数组转化为set
     */
    public void collect() {
        System.out.println("原字符串数组:" + Arrays.toString(arr));
        List<Integer> list = Arrays.stream(arr).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("collect后的list为：" + list);
        Set<Integer> set = list.stream().collect(Collectors.toSet());
        System.out.println("collect后的set为：" + set);
    }

    /**
     * peek,对每个数进行操作，并输出
     */
    public void peek() {
        System.out.println("原字符串数组:" + Arrays.toString(arr));
        long count = Arrays.stream(arr).filter(x -> x > 2).peek(x -> System.out.println("peek:" + x)).count();
        System.out.println(count);
    }

    /**
     * average,求平均数
     */
    public void average() {
        System.out.println("原字符串数组:" + Arrays.toString(arr));
        System.out.println("average求平均");
        Arrays.stream(arr).average().ifPresent(System.out::println);
    }

    /**
     * sum,求和
     */
    public void sum() {
        System.out.println("原字符串数组:" + Arrays.toString(arr));
        System.out.println("sum求和" + Arrays.stream(arr).sum());
    }

    /**
     * max,求最大值
     */
    public void max() {
        System.out.println("原字符串数组:" + Arrays.toString(arr));
        System.out.println("max求最大值" + Arrays.stream(arr).max().getAsInt());
    }

    /**
     * min,求最小值
     */
    public void min() {
        System.out.println("原字符串数组:" + Arrays.toString(arr));
        System.out.println("min求最小值" + Arrays.stream(arr).min().getAsInt());
    }

    /**
     * sorted,排序
     */
    public void sorted() {
        System.out.println("原字符串数组:" + Arrays.toString(arr));
        System.out.println("sorted排序");
        Arrays.stream(arr).sorted().forEach(x -> System.out.print(x + ","));
    }

    public void then() {
        System.out.println("原字符串数组:" + Arrays.toString(arr));
        IntConsumer out = (x) -> System.out.println("out cousume:" + x);
        IntConsumer err = (x) -> System.err.println("err cousume:" + x);
        Arrays.stream(arr).forEach(err.andThen(out));
        Arrays.stream(arr).forEach(out.andThen(err));
    }
}
