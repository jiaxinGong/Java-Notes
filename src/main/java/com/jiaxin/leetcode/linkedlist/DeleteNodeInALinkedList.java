package com.jiaxin.leetcode.linkedlist;

import com.jiaxin.leetcode.linkedlist.base.ListNode;

/**
 * <p>
 *237. Delete Node in a Linked List
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Given linked list -- head = [4,5,1,9], which looks like following:
 * Example 1:
 *
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9
 * after calling your function.
 *
 * Example 2:
 *
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9
 * after calling your function.
 *
 * Note:
 *
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 * </p>
 * Thoughts:删除自己：node.val = node.next.val; node.next = node.next.next;
 * 删除下一个：node.next = node.next.next;
 * @author jiaxin.gong
 * @since 2019/1/27 8:24
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null){
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
