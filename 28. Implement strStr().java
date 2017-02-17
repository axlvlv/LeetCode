/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

needle是不是haystack的子串，是的话就返回这个子串。
/*


public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        
        if(needle.length() == 0){
            return 0;
        }
        
        
        if(haystack.length() < needle.length()){
            return -1;
        }
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            for(int j = 0; j < needle.length(); j++){
                if(haystack.charAt(i + j) != needle.charAt(j)){
                    break;
                }
                if(haystack.charAt(i + j) == needle.charAt(j)){
                    if(j == needle.length() - 1){
                    return i;
                }else{
                    continue;
                    }
                }
            }
        }
        return -1;
    }
}
