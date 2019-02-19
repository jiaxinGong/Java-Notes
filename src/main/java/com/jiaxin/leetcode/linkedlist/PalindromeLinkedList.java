package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;
import java.util.List;

/**
 * <p>
 * 234. Palindrome[回文] Linked List Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1: Input: 1->2 Output: false
 *
 * Example 2: Input: 1->2->2->1 Output: true Follow up: Could you do it in O(n) time and O(1) space?
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/26 23:08
 */
public class PalindromeLinkedList extends AbstractLinkedListTest {

    /**
     * Thoughts:通过快慢指针找到中间节点； 然后翻转一侧的链表节点，然后比较两个链表
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        ListNode right = revert(middle);
        ListNode left = head;
        while (left != null && right != null){
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private ListNode revert(ListNode listNode){
        ListNode temp = new ListNode(0);
        ListNode pre = null;
        while (listNode != null){
            temp.next = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = temp.next;
        }
        return pre;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeLinkedList().isPalindrome(createNodeLists(new int[]{1,2,1})));
    }
}
