/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, 
with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
/**

/*
Method
The main point is two pointer, if they are the same, just move forward, if they doesn't meet the requirement, just continue do
for loop
int[] nums1 = new int[]{1,2,2,2,3};
/**

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int index = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i -1]){
                count++;
                if(count > 2){
                    continue;
                }
            }else{
                count = 1;
            }
            
            nums[index++]= nums[i];
        }
        
        return index;
    }
}

