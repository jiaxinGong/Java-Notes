package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;

/**
 * <p>
 *61. Rotate List
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/27 15:55
 */
public class RotateList extends AbstractLinkedListTest {

    /**
     * Thoughts:计算链表的长度；取k的最小翻转数；找到开始翻转的前一个节点；
     * 截断，翻转
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        int nodeLength = countLength(head);
        k = k % nodeLength;
        if (k == 0) {
            return head;
        }

        int rotateIndex = nodeLength - k;
        ListNode pre = findNode(head, rotateIndex - 1);
        ListNode temp = pre.next;
        ListNode newHead = temp;
        pre.next = null;
        while (temp != null) {
            if (temp.next == null) {
                temp.next = head;
                break;
            }
            temp = temp.next;
        }
        return newHead;
    }

    private ListNode findNode(ListNode head,int index) {
        int count = 0;
        while (head != null) {
            if (count == index) {
                return head;
            }
            ++count;
            head = head.next;
        }
        return null;
    }

    private int countLength(ListNode head) {
        int count = 0;
        while (head != null) {
            ++count;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        print(new RotateList().rotateRight(createNodeLists(new int[]{1, 2, 3, 4, 5}), 0));
    }
}
