package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.ListNode;
import java.util.HashMap;

/**
 * <p>
 * 141. Linked List Cycle Given a linked list, determine if it has a cycle in it. To represent a cycle in the given
 * linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects
 * to. If pos is -1, then there is no cycle in the linked list. Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1 Output: true Explanation: There is a cycle in the linked list, where tail connects
 * to the second node.
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0 Output: true Explanation: There is a cycle in the linked list, where tail connects to
 * the first node.
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1 Output: false Explanation: There is no cycle in the linked list.
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/26 17:20
 */
public class LinkedListCycle {

    /**
     * 解体思路①：用hashMap 判断 解体思路
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        HashMap<ListNode, Boolean> hashMap = new HashMap<>();
        ListNode node = head;
        while (node != null) {
            if (Boolean.TRUE == hashMap.putIfAbsent(node, Boolean.TRUE)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * 解体思路②：用快慢指针，若有循环，快的一定会追上慢的
     */
    public boolean hasCycleOfPoint(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNodeA = new ListNode(3);
        ListNode listNodeB = new ListNode(2);
        ListNode listNodeC = new ListNode(0);
        ListNode listNodeD = new ListNode(-4);
        listNodeA.next = listNodeB;
//        listNodeB.next = listNodeA;
        listNodeB.next = listNodeC;
        listNodeC.next = listNodeD;
        listNodeD.next = listNodeB;

        System.out.println(new LinkedListCycle().hasCycle(listNodeA));
        System.out.println(new LinkedListCycle().hasCycleOfPoint(listNodeA));
    }
}
