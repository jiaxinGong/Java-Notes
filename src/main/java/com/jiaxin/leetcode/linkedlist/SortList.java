package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;
import java.util.List;

/**
 * <p>
 * [Medium]148. Sort List Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3 Output: 1->2->3->4 Example 2:
 *
 * Input: -1->5->3->4->0 Output: -1->0->3->4->5
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/31 16:14
 */
public class SortList extends AbstractLinkedListTest {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null; // 切断链表进行分割
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return mergeTwoListNode(l1, l2);
    }

    private ListNode mergeTwoListNode(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 == null) {
            tail.next = l2;
        }
        if (l2 == null) {
            tail.next = l1;
        }
        return head.next;
    }

    public static void main(String[] args) {
        print(new SortList().sortList(createNodeLists(new int[]{1,5,10,0,2,7,-1})));
    }
}
