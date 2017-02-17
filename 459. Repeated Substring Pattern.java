/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
/*

public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        int len = str.length();
        for(int i = len/2; i >= 1; i--){
            if(len%i == 0){         //说明这个数组可以分组
                String subStr = str.substring(0, i);
                int m = len/i;      //可以分成几组
                int j = 1;          //一定要留在外面，否则出了for循环找不到，会超时
                for(; j < m; j++){
                    if(!subStr.equals(str.substring(j * i, i + j * i))){   //正好是一组一组
                        break;
                    }else{
                        continue;
                    }
                }
                if(j == m){
                    return true;
                }
            }
        }
        return false;
    }
}
