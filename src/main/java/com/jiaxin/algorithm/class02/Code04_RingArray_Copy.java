package com.jiaxin.algorithm.class02;

/**
 * 环形数组实现队列
 * limit  size pushIndex  pollIndex
 */
public class Code04_RingArray_Copy {

    public static class MyQueue {
        private int[] arr;
        private int pushIndex;
        private int pollIndex;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushIndex = 0;
            pollIndex = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列满了，不能再加了");
            }
            size++;
            arr[pushIndex] = value;
            pushIndex = nextIndex(pushIndex);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列空了，不能再出了");
            }
            size--;
            int cur = arr[pollIndex];
            pollIndex = nextIndex(pollIndex);
            return cur;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // 如果现在的下标是i，返回下一个位置
        private int nextIndex(int i) {
            return i < limit - 1 ? i++ : 0;
        }

    }

}
