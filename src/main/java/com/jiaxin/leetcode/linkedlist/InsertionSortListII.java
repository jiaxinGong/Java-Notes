package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;

/**
 * <p>
 * Input: 4->2->1->3 Output: 1->2->3-4
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/2/20 10:03
 */
public class InsertionSortListII extends AbstractLinkedListTest {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode sortHead = head;
        ListNode sortTail = sortHead;

        head = head.next;// 从第二个元素开始循环

        while (head != null) {
            ListNode next = head.next;
            if (head.val < sortTail.val) {

                sortTail.next = null;
                ListNode sortIndex = sortHead;
                ListNode sortPre = null;
                while (sortIndex != null) {
                    if (head.val < sortIndex.val) {
                        if (sortPre == null) {
                            head.next = sortIndex;
                            sortHead = head;
                        } else {
                            head.next = sortIndex;
                            sortPre.next = head;
                        }
                        break;
                    }
                    sortPre = sortIndex;
                    sortIndex = sortIndex.next;
                }
            } else {
                sortTail.next = head;
                sortTail = sortTail.next;
            }
            head = next;
        }
        return sortHead;
    }


    public static void main(String[] args) {
        print(new InsertionSortList()
            .insertionSortList(createNodeLists(new int[]{4, 19, 14, 5, -3, 1, 8, 5, 11, 15})));
    }
}
