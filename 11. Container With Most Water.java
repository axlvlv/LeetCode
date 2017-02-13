/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
/*

/*
Method
AKA, the general idea to find some max is to go through all cases where max value can possibly occur 
and keep updating the max value.
The efficiency of the scan depends on the size of cases you plan to scan.
To increase efficiency, all we need to do is to find a smart way of scan to cut off 
the useless cases and meanwhile 100% guarantee the max value can be reached through the rest of cases.

In this problem, the smart scan way is to set two pointers initialized at both ends of the array. 
Every time move the smaller value pointer to inner array. 
Then after the two pointers meet, all possible max cases have been scanned and the max situation is 100% 
reached somewhere in the scan. Following is a brief prove of this.
/*

public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length -1;
        
        int max = 0;
        
        while(left < right){
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
