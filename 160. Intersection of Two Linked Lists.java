/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

1. 得到2个链条的长度。

2. 将长的链条向前移动差值（len1 - len2）

3. 两个指针一起前进，遇到相同的即是交点，如果没找到，返回null.

相当直观的解法。空间复杂度O(1)， 时间复杂度O(m+n)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        
        int lenA = findLength(headA), lenB = findLength(headB);
        while(lenA > lenB){
            headA = headA.next;
            lenA --;
        }
        
        while(lenA < lenB){
            headB = headB.next;
            lenB --;
        }
        
        //find the intersection until end
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    
    //find a method to calculate the length of A and B
    private int findLength(ListNode node){
        int length = 0;
        while(node != null){
            node = node.next;
            length ++;
        }
        return length;
    }
}
