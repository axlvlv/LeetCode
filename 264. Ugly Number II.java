/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
/*

(1) 1×2, 2×2, 3×2, 4×2, 5×2, …
(2) 1×3, 2×3, 3×3, 4×3, 5×3, …
(3) 1×5, 2×5, 3×5, 4×5, 5×5, …

仔细观察上述三个列表，我们可以发现每个子列表都是一个丑陋数分别乘以2,3,5，而要求的丑陋数就是从已经生成的序列中取出来的，
我们每次都从三个列表中取出当前最小的那个加入序列


public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[1691];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2= 2, factor3 = 3, factor5 = 5;
        for(int i = 1; i < ugly.length; i++){
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if(factor2 == min){
                factor2 = 2*ugly[++index2];
            }
            if(factor3 == min){
                factor3 = 3*ugly[++index3];
            }
            if(factor5 == min){
                factor5 = 5*ugly[++index5];
            }
        }
        
        return ugly[n - 1];
    }
}
