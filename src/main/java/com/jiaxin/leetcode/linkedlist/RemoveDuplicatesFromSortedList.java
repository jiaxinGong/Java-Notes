package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.ListNode;

/**
 * <p>
 * [Easy]83. Remove Duplicates from Sorted List Given a sorted linked list, delete all duplicates
 * such that each element appear only once.
 *
 * Example 1:
 * Input: 1->1->2 Output: 1->2
 *
 * Example 2:
 * Input: 1->1->2->3->3 Output: 1->2->3
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/2/14 10:42
 */
public class RemoveDuplicatesFromSortedList {

    /**
     * Thouths:标记上一个有效节点，寻找到下一个有效节点后再把上一个有效节点指向该节点
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        ListNode tail = head;
        while (tail != null){
            if(pre.val != tail.val){
                pre.next = tail;
                pre = pre.next;
            }
            tail = tail.next;
        }
        if(pre != null){
            pre.next = null;
        }
        return head;
    }
}
