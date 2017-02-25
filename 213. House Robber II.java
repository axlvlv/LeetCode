/*
After robbing those houses on that street, the thief has found himself a new place 
for his thievery so that he will not get too much attention. 
This time, all houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. 
Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
/**

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int n =nums.length;
        if(nums.length == 1){
            return nums[0];
        }
        
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        for(int i = 0; i < n - 1; i++){
            nums1[i] = nums[i];
            nums2[i] = nums[i + 1];
        }
        
        return Math.max(rob1(nums1),rob1(nums2));
    }
    
    private int rob1(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i =2; i <= nums.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        
        return dp[nums.length];
        
    }
}
