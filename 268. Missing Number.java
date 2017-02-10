/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

/*

/*
Method
XOR
根据异或的特性，对于一个数，异或自己是0，异或0是自己，所以我们把0-n都异或一遍，再对着给定数组异或一遍，结果就是缺失的数。
复杂度
时间 O(N) 空间 O(1)





public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int res = nums.length;
        for(int i = 0; i < nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        
        return res;
    }
}
