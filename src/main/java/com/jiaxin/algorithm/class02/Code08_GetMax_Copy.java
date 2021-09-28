package com.jiaxin.algorithm.class02;

public class Code08_GetMax_Copy {

    // 求arr中的最大值
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    // arr[L..R]范围上求最大值  L ... R   N
    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int lMax = process(arr, L, mid);
        int rMax = process(arr, mid + 1, R);
        return Math.max(lMax, rMax);
    }

}
