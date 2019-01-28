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

    /**
     * Thougths: 把数组对半分，然后两个两个合并，最后只剩一个的时候，返回即可
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 前置条件
        if (lists == null || lists.length < 1) {
            return null;
        }

        int length = lists.length;
        if (length == 1) {// 特殊值处理
            return lists[0];
        }
        int mid = (length - 1) / 2;// 中间坐标
        int bound = length - 1;// 数组有效边界
        int index = 0;//开始坐标
        // 两两合并
        while (true) {
            lists[index] = mergeTwoListNode(lists[index],
                (mid + index + 1) <= bound ? lists[(mid + index + 1)] : null);
            index++;
            if (index > mid) {
                index = 0;
                bound = mid;
                if(bound < 1){
                    break;
                }
                mid = mid / 2;
            }
        }

        return lists[0];
    }


    private ListNode mergeTwoListNode(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 == null) {
            tail.next = l2;
        }
        if (l2 == null) {
            tail.next = l1;
        }
        return head.next;
    }

    public static void main(String[] args) {
        // , createNodeLists(new int[]{3})
        print(new MergekSortedLists().mergeKLists(
            new ListNode[]{createNodeLists(new int[]{1, 4, 5})
                , createNodeLists(new int[]{2, 4, 6})
                , createNodeLists(new int[]{3})
                }));
//      print(new MergekSortedLists().mergeTwoListNode(createNodeLists(new int[]{1, 4, 5})
//      ,createNodeLists(new int[]{1, 4})));
    }
}
