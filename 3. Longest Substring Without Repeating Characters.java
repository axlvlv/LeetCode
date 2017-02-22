/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. 

Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

给定一个字符串，从中找出不含重复字符的最长子串的长度。

/*

/*
Time complexity : O(N) 
Space complexity: O(1)

Method: Maximum Sliding Window
Use a hash set to track the longest substring without repeating characters so far, use a fast pointer j to see if character j
is in the hash set or not, if not, add it to the hash set, move j forward and update the max length, otherwise, delete from
the head by using a slow pointer until we can put character j to the hash set.
没有出现过J就一直加，出现过了I就一直加，直到没有出现过为止
/*

/*
Basic java: 
String.length();
String.charAt(int index) : returns the char value at the specified index. An index ranges from 0 to length() - 1;
set.add(E e) : Adds the specified element to this set if it is not already present; e - element to be added to this set
set.remove: Removes the specified element from this set if it is present (optional operation).
o - object to be removed from this set, if present
/*

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int i = 0, j =0, max = 0;
        HashSet<Character> set = new HashSet<>();
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            }else{
                set.remove(s.charAt(i++));
            }
        }
        
        return max;
    }
}
