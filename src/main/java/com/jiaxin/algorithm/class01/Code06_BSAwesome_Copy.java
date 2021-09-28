package com.jiaxin.algorithm.class01;

/**
 * 找局部最小值
 */
public class Code06_BSAwesome_Copy {

    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] <= arr[mid + 1] && arr[mid] <= arr[mid - 1]) {
                return mid;
            } else if (arr[mid] > arr[mid + 1]) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return -1;
    }

    static boolean test(int[] arr, int index) {
        if (arr == null || arr.length == 0) {
            return -1 == index;
        }
        if (arr == null || arr.length == 0) {
            return -1 == index;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0 == index;
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return (arr.length - 1) == index;
        }

        if (index < 0) {
            return false;
        }
        if (index > arr.length - 1) {
            return false;
        }
        if (arr.length == 1 && index == 0) {
            return true;
        }
        if (arr.length > 1) {
            if (arr[index] <= arr[index + 1] && arr[index] < arr[index - 1]) {
                return true;
            }
        }
        return false;
    }

    static int[] generateArr(int maxSize, int maxValue) {
        int[] arr = new int[(int)(Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * (maxValue + 1));
        }
        return arr;
    }

    static void printArr(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxTime = 1;
        int maxSize = 10;
        int maxValue = 100;

        for (int i = 0; i < maxTime; i++) {
            int[] arr = generateArr(maxSize, maxValue);
            int lessIndex = getLessIndex(arr);
            if (!test(arr, lessIndex)) {
                System.out.println(lessIndex);
                printArr(arr);
            }
        }
        System.out.println("================");
        int[] arrB = generateArr(maxSize, maxValue);
        int lessIndex = getLessIndex(arrB);
        System.out.println(lessIndex);
        printArr(arrB);
    }
}
