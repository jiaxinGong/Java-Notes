package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;
import java.util.List;

/**
 * <p>
 *【Hard】23. Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/27 22:15
 */
public class MergekSortedLists extends AbstractLinkedListTest {

    public ListNode mergeKLists(ListNode[] lists) {
        return null;
    }

    public static void main(String[] args) {
        print(new MergekSortedLists().mergeKLists(
            new ListNode[]{createNodeLists(new int[]{1, 4, 5})
                , createNodeLists(new int[]{2, 4, 6})}));
    }
}
