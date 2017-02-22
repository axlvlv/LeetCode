/*
Determine whether an integer is a palindrome. Do this without extra space.
/*

/*
Method
检查回文最直接的方法是将整数转换成字符串，然后用Valid Palindrome那题的算法来检查。但是这么做需要有额外内存。

另一种思路是利用Reverse Integer的算法反转整数，对于回文来说，反转后的整数应该与原整数相同。
如果反转时overflow则一定不是回文。这里需要明确负数到底算不算回文。解中假设不算。

compare half of the digits in x, so don't need to deal with overflow.
extra space usually means O(n) extra space.
x==rev is for the scenery of even digits, x==rev/10 for the odd digits.
/*

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int res = 0;
        int y = x;
        while(y > 0){
            if(res > (Integer.MAX_VALUE - y % 10)/10){
                return false;
            }
            res = res*10 + y%10;
            y = y/10;
        }
        
        return res == x;
        
    }
}

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int res = 0;
        while(x > res){
            res = x % 10 + res * 10;
            x = x/10;
        }
        
        return x == res || x == res/10;
        
    }
}
