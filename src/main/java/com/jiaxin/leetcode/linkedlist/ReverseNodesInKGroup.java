package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;

/**
 * <p>
 *【Hard】25. Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/28 14:08
 */
public class ReverseNodesInKGroup extends AbstractLinkedListTest {

/*    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode knode = head;
//        ListNode pre =
        for (int i = 0; i < k; i++) {// 找k节点
            knode = knode.next;
        }
        if(knode != null){// 找到了k节点
            knode = reverseKGroup(knode.next,k);// 处理k+1节点
            ListNode pre = new ListNode(-1);
            pre.next = head;
            ListNode start = head;
            ListNode then = start.next;

            for (int i = 0; i < k; i++) {
                start.next = then.next;
                then.next = pre.next;
                pre.next = then;
                then = start.next;
            }

        }
        return head;
    }*/

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }

    // ==================================================================

    public ListNode reverseKGroup2(ListNode head, int k) {
        if(head == null || k <= 1){
            return head;
        }
        int n = 1;
        ListNode temp = head;
        while (true){
            temp = head;
            head = reverseBetween(head,(n-1)*k+1,n*k);
            n++;
            if(head == null){
                break;
            }
        }
        return temp;
    }

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
        if(seq2Tail == null){
            return null;
        }

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
        print(new ReverseNodesInKGroup().reverseKGroup(createNodeLists(new int[]{1,2}),2));
    }
}
