package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;

/**
 * <p>
 *203. Remove Linked List Elements
 * Remove all elements from a linked list of integers that have value val.
 * Example:
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * </p>
 * Thoughts:新建一个头节点，标记尾部，尾部指针指向目标不重复的节点，注意处理最后一个节点
 * @author jiaxin.gong
 * @since 2019/1/26 20:14
 */
public class RemoveLinkedListElements extends AbstractLinkedListTest {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode newHead = new ListNode(0);
        ListNode last = newHead;
        while (head != null){
            if(head.val != val){
                last.next = head;
                last = last.next;
            }
            head = head.next;
        }
        last.next = null;// 处理最后一个目标节点，如果遇到链表最后面有不需要的节点，需要特殊处理
        return newHead.next;
    }

    public static void main(String[] args) {
        print(new RemoveLinkedListElements().removeElements(createNodeLists(new int[]{1,3,5,2,5,5}),5));
    }
}
