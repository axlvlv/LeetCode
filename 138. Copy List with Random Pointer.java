/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
/*

/*
Method
An intuitive solution is to keep a hash table for each node in the list, 
via which we just need to iterate the list in 2 rounds respectively to create nodes and assign the values 
for their random pointers. As a result, the space complexity of this solution is O(N), 
although with a linear time complexity.

As an optimised solution, we could reduce the space complexity into constant. 
The idea is to associate the original node with its copy node in a single linked list. In this way, 
we don't need extra space to keep track of the new nodes.

The algorithm is composed of the follow three steps which are also 3 iteration rounds.

Iterate the original list and duplicate each node. The duplicate
of each node follows its original immediately.
Iterate the new list and assign the random pointer for each duplicated node.
Restore the original list and extract the duplicated nodes.
*/

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return head;
        }
        Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode p = head;
        RandomListNode q = newHead;
        map.put(head, newHead);
        p = p.next;
        while(p != null){
            RandomListNode temp = new RandomListNode(p.label);
            map.put(p, temp);
            q.next = temp;
            q = temp;
            p = p.next;
        }
        
        p = head;
        q = newHead;
        while(p != null){
            if(p.random != null){
                q.random = map.get(p.random);
            }else{
                q.random = null;
            }
            p = p.next;
            q = q.next;
        }
        return newHead;
    }
}

