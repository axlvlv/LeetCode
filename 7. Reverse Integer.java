/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
/*

/*
凡是整数操作类的题目，都需要注意几类情况：

1. 整数为负数。
2. 整数为0或者数字中含有0的情况。
3. 是否可能溢出。

具体到这题：
1. 负数情况可以先记录符号，并转为正数
2. x = 10, return 1
3. 本来我们是要判断res*10+num%10>MAX_VALUE, 因为如果乘起来越界那么久错了，为了防止越界，就把他们移到右边去,就变成res>(MAX_VALUE-num%10)/10
/*

public class Solution {
    public int reverse(int x) {
        int num = Math.abs(x);  
        int res = 0;  
        while(num!=0){
            if(res > (Integer.MAX_VALUE - num % 10) / 10){
                return 0;
            }
            res = res * 10 + num % 10;  
            num /= 10;  
        }
        return x>0?res:-res;  
    }
}

