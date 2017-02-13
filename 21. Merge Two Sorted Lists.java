/*
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
/*

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tailnode = dummy;
        
        while(l1 != null && l2!= null){
            if(l1.val < l2.val){
                tailnode.next = l1;
                l1 = l1.next;
            }else{
                tailnode.next = l2;
                l2 = l2.next;
            }
            tailnode = tailnode.next;
        }
        
        if(l1 != null){
            tailnode.next = l1;
        }
        
        if(l2 != null){
            tailnode.next = l2;
        }
        
        return dummy.next;
        
    }
}
