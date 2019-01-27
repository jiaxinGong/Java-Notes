package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;

/**
 * <p>
 * [Medium]24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/27 14:20
 */
public class SwapNodesInPairs extends AbstractLinkedListTest {

    /**
     * Thougths:先定义一组，然后以相同的步伐往下移动
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode next = head.next;
        ListNode temp = new ListNode(-1);
        while (pre != null && next != null) {
            temp.val = pre.val;
            pre.val = next.val;
            next.val = temp.val;

            pre = next.next;
            if (pre == null) {
                break;
            }
            next = pre.next;
        }

        return head;
    }

    public static void main(String[] args) {
        print(new SwapNodesInPairs().swapPairs(createNodeLists(new int[]{1,2,3,4})));
    }
}
