/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
/*

/*
Basic Java
String是不能够修改的，所以要新建一个把原来的string给加进去




public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        
        char[] words = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while(left < right){
            char temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        
        return new String(words);
    }
}
