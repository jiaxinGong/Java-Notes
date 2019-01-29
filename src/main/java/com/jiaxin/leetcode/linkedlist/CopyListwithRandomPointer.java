package com.jiaxin.leetcode.linkedlist;

import com.alibaba.fastjson.JSON;
import com.jiaxin.leetcode.linkedlist.base.RandomListNode;

/**
 * <p>
 * [Medium]138. Copy List with Random Pointer
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/29 17:36
 */
public class CopyListwithRandomPointer {

    /**
     * 深度拷贝链表
     * Thoughts:一个接着一个copy，深度copy需要逐渐创建各个对象
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode tail = dummy;

        while (head != null){
            RandomListNode randomListNode = new RandomListNode(head.label);
            tail.next = randomListNode;
            if(head.random != null){
                randomListNode.random = new RandomListNode(head.random.label);
            }
            tail = tail.next;
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        RandomListNode  r1 = new RandomListNode(1);
        RandomListNode  rr1 = new RandomListNode(1);
        RandomListNode  r2 = new RandomListNode(1);
        RandomListNode  rr2 = new RandomListNode(1);
        RandomListNode  r3 = new RandomListNode(1);
        RandomListNode  rr3 = new RandomListNode(1);
        RandomListNode  r4 = new RandomListNode(1);
        RandomListNode  rr4 = new RandomListNode(1);
        RandomListNode  r5 = new RandomListNode(1);
        RandomListNode  rr5 = new RandomListNode(1);
        r1.random = rr1;
        r1.next = r2;
        r2.random = rr2;
        r2.next = r3;
        r3.random =rr3;
        r3.next = r4;
        r4.random =rr4;
        r4.next = r5;
        r5.random = rr5;

        RandomListNode result = new CopyListwithRandomPointer().copyRandomList(r1);
        System.out.println(JSON.toJSON(result));
    }
}
