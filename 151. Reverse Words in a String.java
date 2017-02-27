/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
/*

/*
Method
复杂度
时间 O(N) 空间 O(N)

思路
将单词根据空格split开来存入一个字符串数组，然后将该数组反转即可。

注意
先用trim()将前后无用的空格去掉
用正则表达式" +"来匹配一个或多个空格
/*


public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        if(s == null || s.length() == 0){
            return s;
        }
        
        String[] words = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--){
            sb.append(words[i]);
            if(i != 0){
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}
