/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        return partition(lists, 0, lists.length - 1);
    }
    
    private ListNode partition(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }
        if(start < end){
            int mid = start + (end - start)/2;
            ListNode left = partition(lists,start, mid);
            ListNode right = partition(lists,mid + 1, end);
            return merge(left,right);
        }else{
            return null;
        }
    }
    
    private ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(left != null && right != null){
            if(left.val <= right.val){
                p.next = left;
                left = left.next;
            }else if(right.val < left.val){
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        if(left != null){
            p.next = left;
        }
        if(right != null){
            p.next = right;
        }
        return dummy.next;
    }
}

public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
