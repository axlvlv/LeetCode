/*
Given an array of integers, every element appears twice except for one. Find that single one.
*/

public class Solution {
    public int singleNumber(int[] nums) {
        // XOR
        // a ^ b = c -> a ^ c = b, b ^ c = a;
        // a ^ a = 0;
        // a ^ 0 = a;
        // (a ^ b) ^ c = a ^ (b ^ c);
        
        int res = 0;
        
        for(int i = 0; i < nums.length; i++){
            res ^= nums[i];
        }
        
        return res;
    }
}
