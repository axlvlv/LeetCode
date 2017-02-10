/*
Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

给定一个长度为n的非空整数数组，计算最少需要多少次移动可以使所有元素相等，一次移动是指将n - 1个元素加1。
/*

/*
Method
那么我们想，为了快速的缩小差距，该选择哪些数字加1呢，不难看出每次需要给除了数组最大值的所有数字加1，这样能快速的到达平衡状态。
但是这道题如果我们老老实实的每次找出最大值，然后给其他数字加1，再判断是否平衡，思路是正确，但是OJ不答应。
正确的解法相当的巧妙，需要换一个角度来看问题，其实给n-1个数字加1，效果等同于给那个未被选中的数字减1，
比如数组[1，2，3], 给除去最大值的其他数字加1，变为[2，3，3]，我们全体减1，并不影响数字间相对差异，变为[1，2，2]，
这个结果其实就是原始数组的最大值3自减1，那么问题也可能转化为，将所有数字都减小到最小值，这样难度就大大降低了，我们只要先找到最小值，
然后累加每个数跟最小值之间的差值即可
/*

public class Solution {
    public int minMoves(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int res = 0;
        int min = nums[0];
        
        for(int num: nums){
            min = Math.min(min, num);
        }
        
        for(int num : nums){
            res += num - min;
        }
        
        return res;
    }
}
