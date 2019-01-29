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

    /**
     * Thouthts: 计算链表长度，找到结束逻辑；推导公式：m=n*k-k+1,n=n*k；利用reverseBetween解决；从前往后解决
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int length = 0;
        ListNode current = head;
        while (current != null){
            length++;
            current = current.next;
        }
        int n = 1;
        while(true){
            if(n*k > length){
                break;
            }
            head = reverseBetweenByMarkThreeNodes(head,(n*k-k+1),n*k);
            ++n;
        }
        return head;
    }

    public ListNode reverseBetweenByMarkThreeNodes(ListNode head, int m, int n) {
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

    //========================================================================

    public ListNode reverseKGroupOfWhile(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroupOfWhile(curr, k); // reverse list with k+1 node as head
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
        print(new ReverseNodesInKGroup().reverseKGroup(createNodeLists(new int[]{1,2,3}),2));
    }
}
