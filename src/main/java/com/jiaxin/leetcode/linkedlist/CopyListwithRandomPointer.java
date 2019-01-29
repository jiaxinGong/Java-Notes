package com.jiaxin.leetcode.linkedlist;

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
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        RandomListNode newHead = new RandomListNode(head.label);
        //Get the newHead in the end
        RandomListNode newCur = newHead;

        if(head.random != null) {
            RandomListNode newRandom = new RandomListNode(head.random.label);
            newCur.random = newRandom;
        }



        return null;
    }

    public RandomListNode copyRandomListOf(RandomListNode head) {
        if(head == null) {
            return null;
        }

        RandomListNode newHead = new RandomListNode(head.label);

        //Get the newHead in the end
        RandomListNode newCur = newHead;

        while(head.next != null) {
            //Copy the next node
            RandomListNode newNext = new RandomListNode(head.next.label);
            newCur.next = newNext;

            //Copy the random node
            if(head.random != null) {
                RandomListNode newRandom = new RandomListNode(head.random.label);
                newCur.random = newRandom;
            }

            //Point the current node to the next node
            newCur = newCur.next;
            head = head.next;
        }

        //The next of the last node must be null,
        //but the random of the last node might not be null
        if(head.random != null) {
            RandomListNode newRandom = new RandomListNode(head.random.label);
            newCur.random = newRandom;
        }

        return newHead;
    }
}
