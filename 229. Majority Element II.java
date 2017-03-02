/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
The algorithm should run in linear time and in O(1) space.
*/

任意一个数组出现次数大于n/3的众数最多有两个的证明：
如果有超过两个，也就是至少三个数字满足“出现的次数大于n/3”，
那么就意味着数组里总共有超过 3*(n/3) = n 个数字，
这与已知的数组大小矛盾，所以，只可能有两个或者更少。
摩尔投票法 Moore Voting

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        
        if(nums == null || nums.length == 0){
            return res;
        }
        
        int m1 = nums[0], m2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
        
        for(int i = 0; i < len; i++){
            if(nums[i] == m1){
                count1++;
            }else if(nums[i] == m2){
                count2++;
            }else if(count1 == 0){
                m1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                m2 = nums[i];
                count2 = 1;
            }else{
                count1 --;
                count2 --;
            }
        }
            
            count1 = 0; count2 = 0;
            for(int i = 0; i < len; i++){
                if(nums[i] == m1){
                    count1 ++;
                }else if(nums[i] == m2){
                    count2 ++;
                }
            }
            
            if(count1 > len/3){
                res.add(m1);
            }
            
            if(count2 > len/3){
                res.add(m2);
            }
            return res;
        }
}

