package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;

/**
 * <p>
 * 160. Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly linked
 * lists begins. Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3 Output:
 * Reference of the node with value = 8 Input Explanation: The intersected node's value is 8 (note that this must not be
 * 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as
 * [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in
 * B.
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/26 18:45
 */
public class IntersectionofTwoLinkedLists extends AbstractLinkedListTest {

    /**
     * Thoughts： 找两个链表的重合点; 长度不同的话，切掉较大的那个 extra length ;长度相同后，会同时达到重合点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int headALength = countLinkedListLength(headA);
        int headBLength = countLinkedListLength(headB);
        if (headALength > headBLength) {
            headA = shirtListLength(headA, headALength - headBLength);
        } else {
            headB = shirtListLength(headB, headBLength - headALength);
        }
        while (headA != null && headB != null) {
            if (headA.val == headB.val) {
//            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int countLinkedListLength(ListNode listNode) {
        int count = 0;
        ListNode temp = listNode;
        while (temp != null) {
            ++count;
            temp = temp.next;
        }
        return count;
    }

    private ListNode shirtListLength(ListNode listNode, int extraLength) {
        while (extraLength > 0 && listNode != null) {
            listNode = listNode.next;
            extraLength--;
        }
        return listNode;
    }

    public static void main(String[] args) {
        print(new IntersectionofTwoLinkedLists()
            .getIntersectionNode(createNodeLists(new int[]{4, 1, 8, 4, 5})
                , createNodeLists(new int[]{5, 0, 1, 8, 4, 5})));
    }
}
