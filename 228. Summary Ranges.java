/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
/*

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums == null){
            return res;
        }
        
        for(int i = 0; i < nums.length; i++){
            int a = nums[i];
            while(i + 1 < nums.length && nums[i] + 1 == nums[i + 1]){
                i++;
            }
            if(a != nums[i]){
                res.add(a + "->" + nums[i]);
            }else{
                res.add(a + "");
            }
        }
        
        return res;
    }
}
