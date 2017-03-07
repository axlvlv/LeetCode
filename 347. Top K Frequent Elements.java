/*
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            if(map.get(num) == null){
                map.put(num,1);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }
        
        List<Integer>[] bucket = new List[nums.length + 1];
        
        for(int key: map.keySet()){
            int count = map.get(key);
            if(bucket[count] == null){
                bucket[count] = new ArrayList<Integer>();
            }
            bucket[count].add(key);
        }
        
        
        List<Integer> res = new ArrayList<Integer>();
        for(int i = nums.length; i > 0; i--){
            if(bucket[i] != null && res.size() < k){
                res.addAll(bucket[i]);
            }
        }
        
        return res;
    }
}
