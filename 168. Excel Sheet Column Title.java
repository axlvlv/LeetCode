/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
/*

/*
Method
从least significant digit开始，不断地除以26取余数

这是我的方法：因为A是1，而不是0，相当于26进制的数都整体减1，才能对应上从0开始的十进制数。
如果是小于等于26的数字，n/26后将等于0，于是不进入循环
如果是大于26的数字，先算出个位数，再算十位数
/*

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        
        while( n!= 0){
            res = res.insert(0, (char)('A' + (n -1)%26));
            n = (n- 1)/26;
        }
        
        return res.toString();
        
    }
}
