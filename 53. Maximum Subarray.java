/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
/*

/*
To calculate the solution for any ele­ment at index “i” has two options

EITHER added to the solution found till “i-1“th index
OR start a new sum from the index “i”.

if 
Method: prefix 

Method: DP
http://algorithms.tutorialhorizon.com/dynamic-programming-maximum-subarray-problem/

Method: Divide and Conquer
Divide-and-conquer method.
    The maximum summation of subarray can only exists under following conditions:
    1. the maximum summation of subarray exists in left half.
    2. the maximum summation of subarray exists in right half.
    3. the maximum summation of subarray exists crossing the midpoints to left and right. 
    1 and 2 can be reached by using recursive calls to left half and right half of the subarraies. 
    Condition 3 can be found starting from the middle point to the left,
    then starting from the middle point to the right. Then adds up these two parts and return. 
    
    T(n) = 2*T(n/2) + O(n)
    this program runs in O(nlogn) time




/*

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minsum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
        
    }
}

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        //state: dp[i] is the max sum from 0 to i
        int[]dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i] + (dp[i -1] > 0 ? dp[i- 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}





