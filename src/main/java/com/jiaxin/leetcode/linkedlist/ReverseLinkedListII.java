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
     * Thoughts: 把链表分成三段；翻转第二段；把翻转后的第二段链接到第三段，第一端链接到第二段
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
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


    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null || head.next == null || m - n == 0) {
            return head;
        }

        ListNode front = head;
        ListNode mFront = findByIndex(head, m - 2);
        ListNode frontTail = mFront;

        ListNode mNode = null;
        if (mFront == null) {
            front = null;
            mNode = head;
        } else {
            mNode = mFront.next;
        }

        ListNode nNode = findByIndex(head, n - 1);
        ListNode after = nNode.next;
        nNode.next = null;

        ListNode pre = null;
        ListNode next = null;

        while (mNode != null) {
            next = mNode.next;
            mNode.next = pre;
            if (pre == null) {
                mNode.next = after;
            }
            pre = mNode;
            mNode = next;
            if (mNode == null) {
                if (front == null) {
                    front = pre;
                } else {
                    frontTail.next = pre;
                }
            }
        }

        return front;
    }

    private ListNode findByIndex(ListNode head, int index) {
        if (index < 0) {
            return null;
        }
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

    public static void main(String[] args) {
        print(new ReverseLinkedListII().reverseBetween(createNodeLists(new int[]{1, 2, 3, 4, 5}), 2, 4));
    }
}
