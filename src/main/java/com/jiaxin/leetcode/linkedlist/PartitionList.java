package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;
/**
 * <p>
 * 【Medium】86. Partition List
 * Given a linked list and a value x, partition it such that all nodes less than x come before
 * nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/27 17:50
 */
public class PartitionList extends AbstractLinkedListTest {

    /**
     * 新建两个节点，一个是作为比给定值小的(val < x)头节点，另一个个是作为不小于给定值(val >= x)的头节点；
     * 记得用标记节点 track head
     * 最终lower.next = equalsAndHigger.next
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode lower = new ListNode(-1);
        ListNode lowerHead = lower;
        ListNode equalsAndHigger = new ListNode(-1);
        ListNode equalsAndHiggerHead = equalsAndHigger;
        while (head != null){
            if(head.val < x){
                lower.next = head;
                lower = lower.next;
            }else{
                equalsAndHigger.next = head;
                equalsAndHigger = equalsAndHigger.next;
            }
            head = head.next;
            if(head == null){
                lower.next = equalsAndHiggerHead.next;
                equalsAndHigger.next = null;
            }
        }
        return lowerHead.next;
    }

    /**
     * Thoughts:
     * 新建两个节点，一个是比给定值小的头节点，一个是不小于给定值的头节点；
     * 较小节点的尾部连接到不小于给定值节点的下一个节点
     * @param head
     * @param x
     * @return
     */
    public ListNode partitionOfCreateNewNode(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode lower = new ListNode(-1);
        ListNode lowerHead = lower;
        ListNode equalsAndHigger = new ListNode(-1);
        ListNode equalsAndHiggerHead = equalsAndHigger;
        while (head != null){
            if(head.val < x){
                lower.next = new ListNode(head.val);
                lower = lower.next;
            }else{
                equalsAndHigger.next = new ListNode(head.val);
                equalsAndHigger = equalsAndHigger.next;
            }
            head = head.next;
            if(head == null){
                lower.next = equalsAndHiggerHead.next;
                equalsAndHigger.next = null;
            }
        }
        return lowerHead.next;
    }

    public static void main(String[] args) {
        print(new PartitionList().partition(createNodeLists(new int[]{1,4,3,2,5,2}),3));
    }
}
