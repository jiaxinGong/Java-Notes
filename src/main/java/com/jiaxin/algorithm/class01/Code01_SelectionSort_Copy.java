package com.jiaxin.algorithm.class01;

import java.util.Arrays;

/**
 * 选择排序</br>
 * 过程：</br>
 * arr[0～N-1]范围上，找到最小值所在的位置，然后把最小值交换到0位置。</br>
 * arr[1～N-1]范围上，找到最小值所在的位置，然后把最小值交换到1位置。</br>
 * arr[2～N-1]范围上，找到最小值所在的位置，然后把最小值交换到2位置。</br>
 * …</br>
 * arr[N-1～N-1]范围上，找到最小值位置，然后把最小值交换到N-1位置。</br>
 * <p>
 * 估算：</br>
 * 很明显，如果arr长度为N，每一步常数操作的数量，如等差数列一般</br>
 * 所以，总的常数操作数量 = a*(N^2) + b*N + c (a、b、c都是常数)</br>
 * <p>
 * 所以选择排序的时间复杂度为O(N^2)。</br>
 */
public class Code01_SelectionSort_Copy {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random()   [0,1)
        // Math.random() * N  [0,N)
        // (int)(Math.random() * N)  [0, N-1]
        int[] arr = new int[(int)(Math.random() * maxSize)];
        for (int i = 0; i < arr.length; i++) {
            // [-? , +?]
            arr[i] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr1 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 1;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            selectionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }

}
