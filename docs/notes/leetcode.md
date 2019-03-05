# leetcode
刷题主题顺序：

## Linked List
**主题心得**

1、快慢指针，经常用来找中间点或者判断链表是否有循环

2、栈具有逆序的特点

**题目**

 21 - Merge Two Sorted Lists
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
 
 83 - Remove Duplicates from Sorted List
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