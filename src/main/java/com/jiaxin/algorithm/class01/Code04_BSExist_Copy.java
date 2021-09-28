package com.jiaxin.algorithm.class01;

/**
 * 二分查找
 * 0 1 2 3 4
 */
public class Code04_BSExist_Copy {

    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return sortedArr[L] == num;
    }

	public static void main(String[] args) {
		int L = 0;
		int R = 4;
		int  mid = L + ((R - L) >> 1);
		System.out.println(mid);
	}
}
