/*
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1
/*

/*
Method 
Priority Queue维护一个最小堆（默认）
PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());变成了最大堆
/*

public class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set  = new HashSet<Integer>();
        
        for(int i : nums){
            if(!set.contains(i)){
                pq.offer(i);
                set.add(i);
                if(pq.size() > 3){
                    set.remove(pq.poll());
                }
            }
        }
        
        if(pq.size() < 3){
            while(pq.size() > 1){
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}
