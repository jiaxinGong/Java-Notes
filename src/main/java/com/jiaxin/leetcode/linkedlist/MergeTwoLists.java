package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;

/**
 * <p>
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/25 15:08
 */
public class MergeTwoLists extends AbstractLinkedListTest {
    // 改变各节点的指针指向

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(l1 == null){
            tail.next = l2;
        }
        if(l2 == null){
            tail.next = l1;
        }

        return head.next;
    }

    public static void main(String[] args) {
        print(new MergeTwoLists().mergeTwoLists(createNodeLists(new int[]{1,3,3,4,5})
            ,createNodeLists(new int[]{2,4,6,6})));
    }
}

