/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
/**

/*
Method
反转数组最简单的方法是交换元素，而交换元素有至少三种方法（临时变量，相加相减，异或）
k可能大于数组长度，旋转不止一次，所以我们要先对k取余
System.out.println(52%18); = 16 18*2+16 = 52

1234567
7654321
5671234
/**

public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return;
        }
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
        
        
        private void reverse(int[] nums, int i, int j){
            while(i < j){
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        
        private void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
}
