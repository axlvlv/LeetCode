/*
Implement atoi to convert a string to an integer.
1. 首先需要丢弃字符串前面的空格；
2. 然后可能有正负号（注意只取一个，如果有多个正负号，那么说这个字符串是无法转换的，返回0。比如测试用例里就有个“+-2”）；
3. 字符串可以包含0~9以外的字符，如果遇到非数字字符，那么只取该字符之前的部分，如“-00123a66”返回为“-123”；
4. 如果超出int的范围，返回边界值（2147483647或-2147483648）。
/*

/*
Basic java
string.trim() = It returns a copy of this string with leading and trailing white space removed, 
or this string if it has no leading or trailing white space.

string.length() Returns the length of this string

string.charAt: Returns the char value at the specified index. An index ranges from 0 to length() - 1.

(int) 

res = 0;
res * 10 + digit(个位数）= res





public class Solution {
    public int myAtoi(String str) {
        if(str == null){  
            return 0;
        }
        
        str = str.trim();         //去掉空格
        
        if(str.length() == 0){    
          return 0;
        }
        
        boolean isNeg = false;     //设置一个正负号
        int i = 0;
        
        if(str.charAt(0) == '-' || str.charAt(0) == '+'){   //确定开头的正负号，如果有正负号，i则从1开始
            i ++;
            if(str.charAt(0) == '-'){
                isNeg = true;
            }
        }
        
        int res = 0;      //通用方法，用每一位求出整数
        
        while(i < str.length()){                      
            if(str.charAt(i) < '0' || str.charAt(i) > '9'){                   
                break;
            }
            int digit = (int)(str.charAt(i) - '0');
            if(isNeg && res > (Integer.MAX_VALUE - digit)/10){
                return Integer.MIN_VALUE;
            }else if(!isNeg && res > (Integer.MAX_VALUE - digit)/10){
                return Integer. MAX_VALUE;
            }
            
            res = res * 10 + digit;
            i++;
        }
        return isNeg ? -res: res;
    }
}
