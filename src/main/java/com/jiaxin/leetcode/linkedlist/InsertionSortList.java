package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;

/**
 * <p>
 * [Medium]147. Insertion Sort List Sort a linked list using insertion sort.
 *
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only
 * the first element in the list. With each iteration one element (red) is removed from the input
 * data and inserted in-place into the sorted list
 *
 *
 * Algorithm of Insertion Sort:
 *
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output
 * list. At each iteration, insertion sort removes one element from the input data, finds the
 * location it belongs within the sorted list, and inserts it there. It repeats until no input
 * elements remain.
 *
 * Example 1:
 *
 * Input: 4->2->1->3 Output: 1->2->3->4
 *
 * Example 2:
 *
 * Input: -1->5->3->4->0 Output: -1->0->3->4->5
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/30 16:36
 */
public class InsertionSortList extends AbstractLinkedListTest {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        print(new InsertionSortList().insertionSortList(createNodeLists(new int[]{1, 3, 4, 6, 2})));
    }
}
