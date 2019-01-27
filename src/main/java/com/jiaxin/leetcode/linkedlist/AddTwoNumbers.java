package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;

/**
 * <p>
 * 【Medium】2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked
 * list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/27 8:44
 */
public class AddTwoNumbers extends AbstractLinkedListTest {

    /**
     * Thoughts: 链表下一个节点没有了则补齐；赋值到长链表；为了确保l1上长链表，当发现链表l1比l2短时，则相互调换尾部
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        ListNode temp = new ListNode(0);
        ListNode pre = l1;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                l1 = temp;// 补位
            } else if (l2 == null) {
                l2 = temp;// 补位
            } else {
                l1.val = l1.val + temp.val;// 进位相加
                temp.val = 0;// 高位复位
            }

            int sigleAdd = l1.val + l2.val;

            l1.val = sigleAdd % 10;// 赋值
            temp.val = sigleAdd / 10;// 高位进位

            if (l2 != null && l2.next != null && l1 != null && l1.next == null) {// 始终赋值到l1,则需要确保extra节点到l1上
                l1.next = l2.next;
                l2.next = null;
            }
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (temp.val > 0) {
            pre.next = temp;
        }
        return head;
    }


    /**
     * Thoughts: 每计算一部，创建一个新节点，最后如果还有高位，则再创建一个节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersOfNewNode(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        int cary = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }
            sum += cary;
            cary = sum / 10;

            node.next = new ListNode(sum % 10);
            node = node.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (cary > 0) {
            node.next = new ListNode(cary);
        }
        return head.next;
    }

    public static void main(String[] args) {
        print(new AddTwoNumbers().addTwoNumbersOfNewNode(createNodeLists(new int[]{2,4,3})
        ,createNodeLists(new int[]{5,6,4})));
    }
}
