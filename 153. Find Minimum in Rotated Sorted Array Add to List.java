/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

主要思路还是跟Search in Rotated Sorted Array差不多，还是通过左边界和中间的大小关系来得到左边或者右边有序的信息，
如果左半边有序，那么左半边最小就是左边第一个元素，可以和当前最小相比取小的，然后走向右半边。否则，那么就是右半半边第一个元素，
然后走向左半边。这样子每次可以截掉一半元素，所以最后复杂度等价于一个二分查找，是O(logn)，空间上只有四个变量维护二分和结果，所以是O(1)。

public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int start = 0, end = nums.length - 1;
        int min = nums[0];
        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[start] <= nums[mid]){
                min = Math.min(min, nums[start]);
                start = mid + 1;
            }else if(nums[start] > nums[mid]){
                min = Math.min(min, nums[mid]);
                end = mid - 1;
            }
        }
        min = Math.min(Math.min(min, nums[start]), nums[end]);
        return min;
    }
}
