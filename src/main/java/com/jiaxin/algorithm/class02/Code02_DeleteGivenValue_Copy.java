package com.jiaxin.algorithm.class02;

/**
 * 删除给定值
 */
public class Code02_DeleteGivenValue_Copy {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node removeValue(Node head, int num) {
        // 删除头部为给定值的情况
        while (head != null) {
            if (head.value == num) {
                head = head.next;
            } else {
                break;
            }
        }
        // 删除除头部后为给定值的情况
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }


        return head;
    }

}
