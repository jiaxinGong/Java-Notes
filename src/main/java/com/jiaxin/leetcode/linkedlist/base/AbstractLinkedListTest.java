package com.jiaxin.leetcode.linkedlist.base;

/**
 * <p>
 *  抽取公共方法
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/26 16:26
 */
public abstract class AbstractLinkedListTest {

    protected static ListNode createNodeLists(int[] vals) {
        ListNode head = new ListNode(0);
        if (vals != null) {
            ListNode tail = head;
            for (int i = 0; i < vals.length; i++) {
                ListNode listNode = new ListNode(vals[i]);
                tail.next = listNode;
                tail = tail.next;
            }
            head = head.next;
        }
        return head;
    }

    protected static void print(ListNode listNode) {
        if(listNode == null){
            return;
        }
        ListNode temp = listNode;
        int i = 0;
        do {
            System.out.print((i == 0 ? "" : "->") + temp.val);
            temp = temp.next;
            i++;
        } while (temp != null);
    }

}
