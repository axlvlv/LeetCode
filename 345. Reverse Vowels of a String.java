/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
/*

/*
Method
Two Pointer
/*

/*
Basic Java
在做string的题的时候，一般都需要将其转化为char
string.toCharArray();
string.contains(string); 我们可以用char[] + ""将char转化成string
string ==null || string.isEmpty() return s 是判断string是否为空最保险的方法
其实isEmpty完全等同于string.length()==0
返回的时候要用return new String(chars);因为是char[] 不是char
/*

public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) return s;
        
        String vowels = "aeiouAEIOU";
        
        char[] chars = s.toCharArray();
        
        int start = 0; 
        int end = s.length() - 1;
        
        while(start < end){
            while(start < end && !vowels.contains(chars[start] + "")){
                start ++;
            }
            
            while(start < end && !vowels.contains(chars[end] + "")){
                end --;
            }
            
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            
            start++;
            end--;
        }
        
        return new String(chars);
    }
}
