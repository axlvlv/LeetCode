/*
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
/**

/*
Method
题目的意思其实就是从1~x层完整楼梯硬币数量加起来，要小于等于n，求最大的x。说到加起来的数量，很容易想到求累加和，我们知道求累加和的公式为：

sum = (1+x)*x/2

这里就是要求 sum <= n 了。我们反过来求层数x。如果直接开方来求会存在错误，必须因式分解求得准确的x值：

(1+x)*x/2 <= n 
x + x*x <= 2*n 
4*x*x + 4*x <= 8*n 
(2*x + 1)*(2*x + 1) - 1 <= 8*n 
x <= (sqrt(8*n + 1) - 1) / 2

其中Math.sqrt()是求平方根的函数。这样我们就求出了x，最后要记得强制转换为int型数。


public class Solution {
    public int arrangeCoins(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
}
