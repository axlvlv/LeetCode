/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
/*

/*
时间复杂度是O(n)，n是字符串的长度，空间复杂度是O(1)。
/*

public class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0 || s == null){
            return 0;
        }
        
        int len = s.length();
        int lastlen = 0;
        
        while(len > 0 && s.charAt(len - 1) == ' '){
            len --;
        } 
        
        while(len > 0 && s.charAt(len - 1) !=' '){
            len --;
            lastlen++;
        }
        
        return lastlen;
    }
}
