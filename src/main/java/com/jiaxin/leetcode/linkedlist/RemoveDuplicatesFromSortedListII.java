package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;

/**
 * <p>
 * [Medium]82. Remove Duplicates from Sorted List II
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/27 16:30
 */
public class RemoveDuplicatesFromSortedListII extends AbstractLinkedListTest {

    /**
     * Thoughts:
     * 因为不清楚第一个节点是否是有效的，所以需要定义一个新节点作为起始节点trustNode，并定义一个变量进行索引newHead；
     * 定义三个节点：上一个节点，当前节点，下一个节点；
     * 当满足当前节点不等于上一个节点，当前节点不等于下一个节点时，该节点是有效节点；
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode trustNode = new ListNode(-1);
        ListNode newHead = trustNode;
        ListNode pre = null;
        ListNode current = head;
        ListNode next = current.next;
        while (current != null) {
            if (pre == null || pre.val != current.val) {
                if (next == null || next.val != current.val) {
                    trustNode.next = current;
                    trustNode = trustNode.next;
                }
            }
            if (pre == null) {
                pre = head;
            } else {
                pre = pre.next;
            }
            current = current.next;
            if (next != null) {
                next = next.next;
            }else{
                trustNode.next = null;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        print(new RemoveDuplicatesFromSortedListII().deleteDuplicates(createNodeLists(new int[]{0,1,1,1,2,3,3,5,6,7,7,7,8,8})));
    }
}
