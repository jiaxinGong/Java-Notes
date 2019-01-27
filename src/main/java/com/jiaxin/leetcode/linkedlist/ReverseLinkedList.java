package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;
import java.util.Stack;

/**
 * <p>
 * 206. Reverse Linked List ;verse a singly linked list. Example: Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/26 21:32
 */
public class ReverseLinkedList extends AbstractLinkedListTest {

    /**
     * Thoughts:利用一个临时对象存储要修改的对象，然后再对对象进行修改，修改过后，保留上一个对象的指针，然后再进行移动
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp = new ListNode(0);
        while (head != null) {
            temp.next = head.next;
            head.next = pre;
            pre = head;
            head = temp.next;
        }
        return pre;
    }

    /**
     * Thoughts:利用栈的特性
     * @param head
     * @return
     */
    public ListNode reverseListOfstack(ListNode head) {
        Stack stack = new Stack();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        while (!stack.isEmpty()) {
            tail.next = (ListNode) stack.pop();
            tail = tail.next;
        }
        tail.next = null;
        return newHead.next;
    }

    public static void main(String[] args) {
        print(new ReverseLinkedList().reverseList(createNodeLists(new int[]{1, 2, 3, 4, 5})));
    }
}
