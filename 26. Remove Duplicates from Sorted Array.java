/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

/*

/*
Method
For example,
int[] nums1 = new int[]{1,1,1,2,3};
做法是维护两个指针，一个保留当前有效元素的长度，一个从前往后扫，然后跳过那些重复的元素。
因为数组是有序的，所以重复元素一定相邻，不需要额外记录。时间复杂度是O(n)，空间复杂度O(1)。最后
做法是维护两个指针，一个保留当前有效元素的长度，一个从前往后扫，然后跳过那些重复的元素。因为数组是有序的，所以重复元素一定相邻，不需要额外记录。时间复杂度是O(n)，空间复杂度O(1)。变成

最后的结果是nums{1,2,3,2,3}


public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int index = 1;                      //这里从1开始，是因为第一位肯定不会有变化，和II那题不一样
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[index] = nums[i];      //如果不相等 双指针就一起走，相等就等到另一个指针指到不相等的为止
                index ++;
            }
        }
        return index;
    }
}
