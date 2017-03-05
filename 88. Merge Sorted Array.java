/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

这是一道数组操作的题目，思路比较明确，就是维护三个index，分别对应数组A，数组B，和结果数组。
然后A和B同时从后往前扫，每次迭代中A和B指向的元素大的便加入结果数组中，然后index-1，另一个不动

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null && nums2 == null){
            return;
        }
        int index1 = m  - 1, index2 = n - 1, index3 = m + n - 1;
        while(index1 >= 0 && index2 >= 0){
                if(nums1[index1] >= nums2[index2]){
                    nums1[index3--] = nums1[index1--];
                }else{
                    nums1[index3--] = nums2[index2--];
                }
        }
        while(index2 >= 0){
            nums1[index3--] = nums2[index2--];
        }

    }
}
