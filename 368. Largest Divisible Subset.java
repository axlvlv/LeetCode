/*
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

nums: [1,2,3]

Result: [1,2] (of course, [1,3] will also be ok)
Example 2:

nums: [1,2,4,8]

Result: [1,2,4,8]

给定一个数组，求其中的一个最大子集，要求该子集中任意的两个元素满足 x % y ==0 或者 y % x==0
/*

/*
Method
先把数组排好序。首先要明确，若a<b且b%a==0 ,  b <c 且 c%b==0那么必然有c%a==0
我们首先可以先给数组排序，这样我们每次就只要看后面的数字能否整除前面的数字。

dp[i]表示nums数组从0到i的最大集合的size. 这题应该分成两个问题：

得到最大集合size
输出这个集合

对于第一个问题，最大集合size就是dp数组的最大值，可以边画表边维护一个当前最大值;
对于第二个问题，我们要维护一个parent数组，记录nums[i]加入到了哪个集合;
dp[i] = max(dp[i], dp[j] + 1), where 0<=j<i
/*




