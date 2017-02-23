/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
/*

/*
Method
Similar to 3 Sum problem, use 3 pointers to point current element, next element and the last element. 
If the sum is less than target, it means we have to add a larger element so next element move to the next. 
If the sum is greater, it means we have to add a smaller element so last element move to the second last element.
Keep doing this until the end. Each time compare the difference between sum and target, 
if it is less than minimum difference so far, then replace result with it, otherwise keep iterating.
Similar to 3 Sum problem, use 3 pointers to point current element, next element and the last element. If the sum is less than target, it means we have to add a larger element so next element move to the next. If the sum is greater, it means we have to add a smaller element so last element move to the second last element. Keep doing this until the end. Each time compare the difference between sum and target, if it is less than minimum difference so far, then replace result with it, otherwise keep iterating.


 /*
 这里要维护sum和res两个变量，才好比较，因为left为0已经做好了，所以接下来left要从i= 1开始比较，还要注意去掉重复的
/*
 
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        int res = sum;
        
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i] != nums[i - 1]){
                int left = i + 1, right = nums.length - 1;
                while(left < right){
                    sum = nums[left] + nums[right] + nums[i];
                    if(sum == target){
                        return sum;
                    }else if(sum < target){
                        while(left < right && nums[left] == nums[left + 1]){
                           left++; 
                        }
                        left++;
                    }else{
                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        right--;
                    }
                    
                    if(Math.abs(target - sum) < Math.abs(target - res)){
                        res = sum;
                    }
                }
            }
        }
        return res;
    }
}
