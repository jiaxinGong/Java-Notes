package com.jiaxin.leetcode.linkedlist;

import com.alibaba.fastjson.JSON;
import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;

/**
 * <p>
 * 【Medium】143. Reorder List
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/30 15:24
 */
public class ReorderList extends AbstractLinkedListTest {

    /**
     * Thouthts:快慢指针找到中间点,标记前后半段;
     * 后半段反转;
     * 前后半段再逐个合并成一段;
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }

        ListNode slow = head;
        ListNode  fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode seq2 = slow.next;
        slow.next = null;

      // 反转第二段
        ListNode pre = null;
        ListNode temp = null;
        while (seq2 != null){
            temp = seq2.next;
            seq2.next = pre;
            pre = seq2;
            seq2 = temp;
        }
        ListNode revert = pre;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        ListNode headTemp = head;
        ListNode revertTemp = head;
        while (head != null && revert != null){
            headTemp = head.next;
            revertTemp = revert.next;

            tail.next = head;
            tail = tail.next;

            tail.next = revert;
            tail = tail.next;

            head = headTemp;
            revert = revertTemp;
        }
        tail.next = head;

        head = dummy.next;
    }

    public static void main(String[] args) {
        ListNode temp = createNodeLists(new int[]{1,2,3,4,5});

        new ReorderList().reorderList(temp);

        System.out.println(JSON.toJSONString(temp));
    }
}
