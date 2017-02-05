/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].




/*

/*
Method
Binary Search
If A[mid] < target, then the range must begins on the right of mid (hence i = mid+1 for the next iteration)
If A[mid] > target, it means the range must begins on the left of mid (j = mid-1)
If A[mid] = target, then the range must begins on the left of or at mid (j= mid)
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        
        int start, end ;
        int[] bound = new int[2];
        
        //search for the left bound 
        start = 0;
        end = nums.length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start) /2;
            if(nums[mid] >= target){
                end = mid;
            }else{
                start = mid;
            }
        }
        
        if(nums[start] == target){
            bound[0] = start;
        }else if(nums[end] == target){
            bound[0] = end;
        }else{
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        //search for the right bound
        start = 0;
        end = nums.length - 1;
         while(start + 1 < end){
            int mid = start + (end - start) /2;
            if(nums[mid] <= target){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if(nums[end] == target){
            bound[1] = end;
        }else if(nums[start] == target){
            bound[1] = start;
        }else{
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        return bound;
        
    }
}
