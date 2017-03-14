/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
/*

/*
Method
Binary search
这题一共就分几种情况
[1,2,3,4,5] target = 数组中的数 如果是这样子的话，用老的binarysearch 的方法就能做出
还分三种特殊情况
1.target比start还要小，那么nums[start] > target, return 0;
2.target比end还要大， 那么nums[end] < target,  return end + 1；
3.target在start 和end 中间，那么就直接返回start + 1
/*

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int start = 0, end = nums.length - 1, mid;
        if(target <= nums[0]){
            return 0;
        }
        if(target > nums[end]){
            return nums.length;
        }
        while(start + 1 < end){
            mid = start + (end - start)/2;
            if(nums[mid] == target){
                end = mid;
            }else if(nums[mid] > target){
                end = mid;
            }else if(nums[mid] < target){
                start = mid;
            }
        }
        if(nums[start] == target){
            return start - 1;
        }else{
            return start + 1;
        }
    }
}
