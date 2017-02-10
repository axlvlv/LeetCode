/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.

给定一个n + 1个数的数组，数组中每个元素的值介于1~n，假设只有一个元素是重复的，求这个元素

你不能修改这个数组
空间复杂度要求O(1)
时间复杂度小于O(n2)
只有一个元素是重复的，但可能重复不止一次
/*

/*
Method
1. 哈希表法
复杂度
时间 O(N) 空间 O(N)

思路
遍历数组时，用一个集合记录已经遍历过的数，如果集合中已经有了说明是重复。但这样要空间，不符合。

2. 暴力法
复杂度
时间 O(N^2) 空间 O(1)

思路
如果不用空间的话，最直接的方法就是选择一个数，然后再遍历整个数组看是否有跟这个数相同的数就行了。

3. 排序法
复杂度
时间 O(NlogN) 空间 O(1)

思路
更有效的方法是对数组排序，这样遍历时遇到前后相同的数便是重复，但这样要修改原数组，不符合要求。

4.二分法
复杂度
时间 O(NlogN) 空间 O(1)

思路
实际上，我们可以根据抽屉原理简化刚才的暴力法。
我们不一定要依次选择数，然后看是否有这个数的重复数，
我们可以用二分法先选取n/2，按照抽屉原理，整个数组中如果小于等于n/2的数的数量大于n/2，
说明1到n/2这个区间是肯定有重复数字的。
比如6个抽屉，如果有7个袜子要放到抽屉里，那肯定有一个抽屉至少两个袜子。这里抽屉就是1到n/2的每一个数，而袜子就是整个数组中小于等于n/2的那些数。这样我们就能知道下次选择的数的范围，如果1到n/2区间内肯定有重复数字，则下次在1到n/2范围内找，否则在n/2到n范围内找。下次找的时候，还是找一半。

注意
我们比较的mid而不是nums[mid]
因为mid是下标，所以判断式应为cnt > mid，最后返回min
举例：1，1，2，3
min = 0, max = 3
mid = 1
当min<= max, 遍历整个数组，找到小于等于mid的数字，count++
小于等于1的有两个，所以count = 2, 大于mid，说明重复数字一定出现在前半部分
max = mid - 1 = 0
第二次while min,max = 0 遍历找比0小的，count = 0,count = mid，所以说后半段一定有重复
min = 1这时min > max了 所以就返回min = 1
/*

public class Solution {
    public int findDuplicate(int[] nums) {
        int min = 0, max = nums.length - 1;
        while(min <= max){
            // 找到中间那个数
            int mid = min + (max - min) / 2;
            int cnt = 0;
            // 计算总数组中有多少个数小于等于中间数
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= mid){
                    cnt++;
                }
            }
            // 如果小于等于中间数的数量大于中间数，说明前半部分必有重复
            if(cnt > mid){
                max = mid - 1;
            // 否则后半部分必有重复
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}


