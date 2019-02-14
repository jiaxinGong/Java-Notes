package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.ListNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <p>
 *
 * [Medium]142. Linked List Cycle II Given a linked list, return the node where the cycle begins. If
 * there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the
 * position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no
 * cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/30 10:05
 */
public class LinkedListCycleII {

    /**
     * Thoughts: 利用快慢指针找出相遇点；
     * 推导公式：从头节点到循环点的距离是相遇点到循环点的距离存在整数倍关系
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null &&  fast.next != null) {
            if (slow == fast) {
                while (head != slow.next) {
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }


    /**
     * Thoughts:使用hashMap解决
     * @param head
     * @return
     */
    public ListNode detectCycleOfMap(ListNode head) {
        Map<ListNode,Boolean> cash =  new HashMap<>();
        while (head != null){
            if(Boolean.TRUE == cash.putIfAbsent(head,Boolean.TRUE)){
                return head;
            }
            head = head.next;
        }
        return null;
    }


    public static void main(String[] args) {

    }
}
