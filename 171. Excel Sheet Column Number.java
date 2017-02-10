/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
/*

/*
Method
26进制转化为10进制
/*

public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int res = 0;
        
        char[] chars = s.toCharArray();
        for(char c : chars){
            res = res*26 + (c - 'A' + 1);
        }
        
        return res;
    }
}


