package com.jiaxin.leetcode.math;

/**
 * <p>
 * 69. x 的平方根
 *
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * 输入: 4输出: 2
 * 示例 2:
 * 输入: 8输出: 2说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/25 11:11
 */
public class SqrtSolution {

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int low = 1;
        int high = x;
        while (low <= high) {
            int mind = low + ((high - low) / 2);// 中间坐标的计算
            int sqrt = x / mind;
            if (sqrt == mind) { // 即 sqrt * sqrt = x
                return mind;
            } else if (sqrt < mind) {// mind 偏大  high 左移，从mind开始
                high = mind - 1;
            } else {// mind 偏小  low 右移 从 mind开始
                low = mind + 1;
            }
        }
        return high;
    }
}
