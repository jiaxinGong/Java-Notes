package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;
import java.util.List;

/**
 * <p>
 *【Medium】19. Remove Nth Node From End of List
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/27 11:46
 */
public class RemoveNthNodeFromEndOfList extends AbstractLinkedListTest {

    /**
     * Thouthts:计算出链表的长度，在计算出需要删除的坐标；
     * 由于有可能是删除坐标为0的头节点，所以需要新建一个节点作为起始节点进行标记；
     * 由于需要删除节点，所以需要记录上一节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        int length = countLength(head);
        int removeIndex = length - n;
        int currentIndex = 0;
        while (head != null) {
            if (currentIndex == removeIndex) {
                pre.next = head.next;
                break;
            }
            ++currentIndex;
            pre = head;
            head = head.next;
        }
        return newHead.next;
    }

    private int countLength(ListNode head) {
        int count = 0;
        while (head != null) {
            ++count;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        print(new RemoveNthNodeFromEndOfList().removeNthFromEnd(createNodeLists(new int[]{1,2,3,4,5}),2));
    }
}
