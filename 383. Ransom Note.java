/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
/*

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(char cm : magazine.toCharArray()){
            int newCount = map.getOrDefault(cm, 0) + 1;
            map.put(cm, newCount);
        }
        
        for(char cr: ransomNote.toCharArray()){
            int newCount = map.getOrDefault(cr, 0) - 1;
            if(newCount < 0){
                return false;
            }
            map.put(cr, newCount);
        }
        
        return true;
        
    }
}
