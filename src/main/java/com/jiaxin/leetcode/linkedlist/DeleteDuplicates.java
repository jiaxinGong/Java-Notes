package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;

/**
 * <p>
 * 83. Remove Duplicates from Sorted List Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2 Output: 1->2 Example 2:
 *
 * Input: 1->1->2->3->3 Output: 1->2->3
 *
 * 解题思路：定义两个节点，一个标记上一个有效节点，一个标记下一个有效节点，然后有上一个有效节点指向下一个有效节点
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/26 15:31
 */
public class DeleteDuplicates extends AbstractLinkedListTest {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;// 上一个有效节点
        ListNode tail = head;// 后一个有效节点
        while (tail != null) {
            if (pre.val != tail.val) {
                pre.next = tail;
                pre = tail;
            }
            tail = tail.next;
        }
        if (pre != null) {
            pre.next = null;// 处理最后的连续节点问题
        }
        return head;
    }

    public static void main(String[] args) {
        print(new DeleteDuplicates()
            .deleteDuplicates(createNodeLists(new int[]{1,2,2,3,3,3})));
    }
}
