/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.
/*

public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < nums[end] ){   //right is sorted
                if(target > nums[mid] && target <= nums[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }else if(nums[mid] > nums[end]){    //left is sorted
                if(target >= nums[start] && target < nums[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }
        }
        
        if(nums[start] == target){
            return start;
        }
        
        if(nums[end] == target){
            return end;
        }
        return -1;
        
    }
}
