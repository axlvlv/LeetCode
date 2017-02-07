/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

一个数组中，0代表红色，1代表白色，2代表蓝色。请按照红-白-蓝色的顺序排好。不能使用sort函数。
/*

/*
Method: Two pointer 实际是3根指针 一个left从0开始，一个right从最后开始， 一个i 跟他们替换
我们需要一边对数组扫描，一边完成对应数的放置
我们不能够用超过常数的空间来存储临时变量
在有了这样的结论之后，我们基本上可以确定，我们的做法只能够是，将数字在数组中不断的交换，直到完成排序。
如果我们令i从0依次遍历到n-1，即访问nums的每一个元素：

如果nums[i]==0，说明我们需要将这个数放到最前面
如果ums[i]==2，说明我们需要将这个数放到最后面
想要放到“最前面”和“最后面”是不太现实的事情（时间复杂度太高)
于是我们可以采取折衷的方式，即与从前往后第一个不是0的数交换和与从后往前第一个不是2的数交换。

按照这样的方式，我们就会把所有的0放置在数组的最前方，所有的2放置在数组的最后方，那么中间自然就是剩下来的1了。要注意i = left, i <= righ，
否则会越界先算2的情况，因为这样子可以快一点，直接把2往后调

？？？为什么要用right 和left呢？left,right改变上面括号里的也会改变吗
/*

public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null | nums.length == 0){
            return;
        }
        
        int left = 0, right = nums.length - 1;
        for(int i = left; i <= right;){
            if(nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right --;
            }else if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;i++;
            }else{
                i++;
            }
        }
    }
}

