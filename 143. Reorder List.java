（1）将链表切成两半，也就是找到中点，然后截成两条链表；（2）将后面一条链表进行reverse操作，就是反转过来；（3）将两条链表按顺序依次merge起来。


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        //find the middle 
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode midhead = reverse(slow.next);
        mid.next = null;
        merge(head, midhead);
    }
        
        //reverse the linked list, 1->2->3->4->5 to 1->2->3->5->4
        private ListNode reverse(ListNode head){
            ListNode pre = null;
            while(head != null){
                ListNode temp = head.next;
                head.next = pre;
                pre = head;
                head = temp;
            }
            return pre;
        }
        private void merge(ListNode l1, ListNode l2){
            while(l1 != null && l2 != null){
                ListNode n1 = l1.next;
                ListNode n2 = l2.next;
                l1.next = l2;
                if(n1 == null){
                    break;
                }
                l2.next = n1;
                l1 = n1;
                l2 = n2;
            }
        }
}
