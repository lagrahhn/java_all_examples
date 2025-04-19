package cn.lagrahhn.java8.ParallelSort;

import java.util.Arrays;

public class ParallelSortFunc {
    /**
     * 并行排序
     */
    public void parallelSort() {
        int[] arr = {4, 12, 1, 3, 5, 7, 9};
        Arrays.parallelSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 并行前缀,求累计结果
     */
    public void collectParallel() {
        int[] arr = {4, 12, 1, 3, 5, 7, 9};
        System.out.println("原数组为" + Arrays.toString(arr));
        Arrays.parallelPrefix(arr, Integer::sum);
        System.out.println(Arrays.toString(arr));

    }
}
