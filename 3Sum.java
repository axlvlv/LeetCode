/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
/*

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null){
            return null;
        }
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || i > 0 && nums[i] != nums[i - 1]){
                int left = i + 1, right = nums.length - 1, sum = 0 - nums[i];
                while(left < right){
                    if(nums[left] + nums[right] == sum){
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]){
                                left++;
                        }
                        while(left < right && nums[right] == nums[right - 1]){
                                right --;
                        }
                        left++;
                        right--;
                    }else if(nums[left] + nums[right] < sum){
                        left++;
                    }else{
                        right--;
                    }
                }
                
            }
        }
        return res;
    }
}
