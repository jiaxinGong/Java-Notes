package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;

/**
 * <p>
 *【Medium】92. Reverse Linked List II
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/27 18:30
 */
public class ReverseLinkedListII extends AbstractLinkedListTest {

    /**
     * Thougths:创建三个节点pre[开始节点的前一节点]、start[开始节点]、then[后一节点]；
     * 后一节点移动到pre的后一节点，以此反复移动
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);// 创建一个虚拟节点标记链表头部
        dummy.next = head;

        ListNode pre = dummy;// 用来标记转换前的节点
        for(int i = 0; i< m-1;i++){
            pre = pre.next;// 找到待反转的前一个节点
        }

        ListNode start = pre.next;// 标记需要反转的起始节点
        ListNode then = start.next;// 标记下一节点

        for(int i = 0;i< n - m;i++){
            start.next =  then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }

    // ===================================================================================

    /**
     * Thoughts: 把链表分成三段；翻转第二段；把翻转后的第二段链接到第三段，第一端链接到第二段
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetweenOfSegment(ListNode head, int m, int n) {
        // 前置条件
        if (head == null || head.next == null || m - n == 0) {
            return head;
        }
        ListNode seq1Head = head;
        ListNode seq1Tail = findByPosition(head, m - 1);

        ListNode seq2Head = null;
        ListNode seq2Tail = findByPosition(head, n);

        if (seq1Tail == null) {
            seq1Head = null;
            seq2Head = head;
        } else {
            seq2Head = seq1Tail.next;
        }

        ListNode seq3Head = seq2Tail.next;
        seq2Tail.next = null;

        // 翻转
        ListNode oldNext = null;
        ListNode pre = null;
        while (seq2Head != null) {
            oldNext = seq2Head.next;
            seq2Head.next = pre;
            if (pre == null) {
                seq2Head.next = seq3Head;
            }
            pre = seq2Head;
            if (oldNext == null) {
                if (seq1Head != null) {
                    seq1Tail.next = seq2Head;
                } else {
                    seq1Head = seq2Head;
                }
            }
            seq2Head = oldNext;
        }
        return seq1Head;
    }

    private ListNode findByPosition(ListNode head, int position) {
        if (position < 1) {
            return null;
        }
        int count = 1;
        while (head != null) {
            if (count == position) {
                return head;
            }
            ++count;
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        print(new ReverseLinkedListII().reverseBetween(createNodeLists(new int[]{1, 2, 3, 4, 5}), 2, 4));
    }
}
