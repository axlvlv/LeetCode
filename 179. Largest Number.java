/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
/*

public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }
        
        String[] s_nums = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            s_nums[i] = String.valueOf(nums[i]);
        }
        
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        };
        
        Arrays.sort(s_nums, comp);
        
        if(s_nums[0].equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s: s_nums){
            sb.append(s);
        }
        
        return sb.toString();
    }
}
