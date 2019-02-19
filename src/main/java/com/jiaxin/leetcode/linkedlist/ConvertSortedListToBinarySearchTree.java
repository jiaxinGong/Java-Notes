package com.jiaxin.leetcode.linkedlist;

import com.alibaba.fastjson.JSON;
import com.jiaxin.leetcode.linkedlist.base.AbstractLinkedListTest;
import com.jiaxin.leetcode.linkedlist.base.ListNode;
import com.jiaxin.leetcode.linkedlist.base.TreeNode;

/**
 * <p>
 * 有序链表转换成平衡二叉树
 *
 * [Medium]109. Convert Sorted List to Binary Search Tree
 *Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
 * the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/29 11:22
 */
public class ConvertSortedListToBinarySearchTree extends AbstractLinkedListTest {

    /**
     * 利用树的中序遍历法
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }

        return toBST(head,null);
    }

    public TreeNode toBST(ListNode head, ListNode tail){
        if(head == tail){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail){ // 找到中间节点
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode treeNode = new TreeNode(slow.val);
        treeNode.left = toBST(head,slow);// 左子树
        treeNode.right = toBST(slow.next,tail);// 右子树

        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode =  new ConvertSortedListToBinarySearchTree().sortedListToBST(createNodeLists(new int[]{-10,-3,0,5,9,14,1,5,17,18}));
        System.out.println(JSON.toJSONString(treeNode));
    }
}
