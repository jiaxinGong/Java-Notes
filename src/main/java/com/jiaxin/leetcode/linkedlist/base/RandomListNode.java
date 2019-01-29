package com.jiaxin.leetcode.linkedlist.base;

/**
 * <p>
 * Definition for singly-linked list with a random pointer.
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/29 17:34
 */

public class RandomListNode {

    public int label;
    public RandomListNode next, random;

    public RandomListNode(int x) {
        this.label = x;
    }
};
