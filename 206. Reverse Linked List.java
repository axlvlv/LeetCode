/*
Reverse a singly linked list.
*/



public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode pre = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        
        return pre;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }
    
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
