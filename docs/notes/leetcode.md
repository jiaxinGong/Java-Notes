# leetcode
刷题主题顺序：链表、二叉树、回溯、深度广度优先遍历、图、贪心、递归、数组、哈希表
刷题难易度顺序：由易到难

## Linked List
**主题心得**

1、快慢指针，经常用来找中间点或者判断链表是否有循环

2、栈具有逆序的特点

**题目**

 21【Easy】 - Merge Two Sorted Lists 合并两个有序链表
 Merge two sorted linked lists and return it as a new list.
 The new list should be made by splicing together the nodes of the first two lists.
 
 Example:
 
 Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 
 解题思路：改变各节点的指针指向
 
 ```
 public class MergeTwoListsSolution {
 
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         ListNode head = new ListNode(0);
         ListNode tail = head;
         while (l1 != null && l2 != null){
             if(l1.val < l2.val){
                 tail.next = l1;
                 l1 = l1.next;
             }else {
                 tail.next = l2;
                 l2 = l2.next;
             }
             tail = tail.next;
         }
         if(l1 == null){ 
             tail.next = l2;// 防止丢失另一节点数据
         }
         if(l2 == null){
             tail.next = l1;// 防止丢失另一节点数据
         }
 
         return head.next;
     }
 }
 ```
 
 83【Easy】 - Remove Duplicates from Sorted List 删除重复的节点
 Given a sorted linked list, delete all duplicates such that each element appear only once.
 
 Example 1:
 
 Input: 1->1->2
 Output: 1->2
 Example 2:
 
 Input: 1->1->2->3->3
 Output: 1->2->3
 
 解题思路：标记上一个有效节点，寻找到下一个有效节点后再把上一个有效节点指向该节点

```
public ListNode deleteDuplicates(ListNode head) {
   ListNode pre = head;
   ListNode next = head;
   while (next != null){
       if(pre.val != next.val){
           pre.next = next;
           pre = pre.next;
       }
       next = next.next;
   }
   if(pre != null){
       pre.next = null;
   }
   return head;
}
```

141【Easy】 - Linked List Cycle 判断链表是否有循环

Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

 

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.


Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.


Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 
 解题思路：用快慢指针，若有循环，快的一定会追上慢的
 ```
 public boolean hasCycleOfPoint(ListNode head) {
     if (head == null || head.next == null) {
         return false;
     }
     ListNode slow = head;
     ListNode fast = head.next;
     while (slow != null && fast.next != null) {
         if (slow == fast) {
             return true;
         }
         slow = slow.next;
         fast = fast.next.next;
     }
     return false;
 }
 ```
 160【Easy】 - Intersection of Two Linked Lists 找两个链表的重合点
 
 Write a program to find the node at which the intersection of two singly linked lists begins.
 
 For example, the following two linked lists:
 
 
 begin to intersect at node c1.
 
  
 
 Example 1:
 
 
 Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 Output: Reference of the node with value = 8
 Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
  
 
 Example 2:
 
 
 Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 Output: Reference of the node with value = 2
 Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
  
 
 Example 3:
 
 
 Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 Output: null
 Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 Explanation: The two lists do not intersect, so return null.
 
  解题思路：长度不同的话，切掉较大的那个 extra length ;长度相同后，会同时达到重合点
  
  ```
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if (headA == null || headB == null) {
          return null;
      }
      int headALength = countLinkedListLength(headA);
      int headBLength = countLinkedListLength(headB);
      if (headALength > headBLength) {
          headA = shirtListLength(headA, headALength - headBLength);
      } else {
          headB = shirtListLength(headB, headBLength - headALength);
      }
      while (headA != null && headB != null) {
          if (headA.val == headB.val) {
//            if (headA == headB) {
              return headA;
          }
          headA = headA.next;
          headB = headB.next;
      }
      return null;
  }
  
  private int countLinkedListLength(ListNode listNode) {
      int count = 0;
      ListNode temp = listNode;
      while (temp != null) {
          ++count;
          temp = temp.next;
      }
      return count;
  }

  private ListNode shirtListLength(ListNode listNode, int extraLength) {
      while (extraLength > 0 && listNode != null) {
          listNode = listNode.next;
          extraLength--;
      }
      return listNode;
  }
  ```
  203【Easy】 - Remove Linked List Elements 删除指定值的节点
  
  Remove all elements from a linked list of integers that have value val.
  
  Example:
  
  Input:  1->2->6->3->4->5->6, val = 6
  Output: 1->2->3->4->5
  
  解题思路：新建一个头节点，标记尾部，尾部指针指向目标不重复的节点，注意处理最后一个节点
  
  ```
  public ListNode removeElements(ListNode head, int val) {
      if(head == null){
          return null;
      }
      ListNode newHead = new ListNode(0);
      ListNode last = newHead;
      while (head != null){
          if(head.val != val){
              last.next = head;
              last = last.next;
          }
          head = head.next;
      }
      last.next = null;// 处理最后一个目标节点，如果遇到链表最后面有不需要的节点，需要特殊处理
      return newHead.next;
  }
  ```
  
  206【Easy】 - Reverse Linked List 反转单链表
  
  Reverse a singly linked list.
  
  Example:
  
  Input: 1->2->3->4->5->NULL
  Output: 5->4->3->2->1->NULL
  
  解题思路：标记上一个对象和下一个对象，然后再改变指针的指向
    
  ```
  public ListNode reverseList(ListNode head) {
      ListNode pre = null;
      ListNode next = null;
      while (head != null) {
          next = head.next;
          head.next = pre;
          pre = head;
          head = next;
      }
      return pre;
  }
  ```
 234【Easy】-  Palindrome Linked List 回文
 
 Given a singly linked list, determine if it is a palindrome.
 
 Example 1:
 
 Input: 1->2
 Output: false
 Example 2:
 
 Input: 1->2->2->1
 Output: true
 
 解题思路： 通过快慢指针找到中间节点； 然后翻转一侧的链表节点，然后比较两个链表
 
 ```
  public boolean isPalindrome(ListNode head) {
      if (head == null || head.next == null) {
          return true;
      }
      ListNode middle = findMiddle(head);
      ListNode right = revert(middle);
      ListNode left = head;
      while (left != null && right != null){
          if(left.val != right.val){
              return false;
          }
          left = left.next;
          right = right.next;
      }
      return true;
  }
 
  private ListNode revert(ListNode listNode){
      ListNode temp = new ListNode(0);
      ListNode pre = null;
      while (listNode != null){
          temp.next = listNode.next;
          listNode.next = pre;
          pre = listNode;
          listNode = temp.next;
      }
      return pre;
  }
 
  private ListNode findMiddle(ListNode head) {
      ListNode slow = head;
      ListNode fast = head.next;
      while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
      }
      return slow;
  }
 ```
 
 