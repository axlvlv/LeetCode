/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
/*

/*
Method:先把一个数遍历到底2 ->2,2 ->2,2,2 ->2,2,2,2 直到target 的情况遇到前面的判断条件才返回
然后做下面的remove操作，i = 1开始继续，2，2，2，3 超过target了,remove
return 回去 i = 2. 2,2,2,6  超过target了,remove
return 回去 i = 3. 2，2，2，7 超过target了,remove

Helper第一次调用 
helper({2,3,6,7}, target: 7, temp: size = 0)
helper({2,3,6,7}, target: 5, temp: size = 1) //通过遍历的方式把2加入了temp 于是我们只要判断接下来的值是不是等于5就可以了,
这时从头做了一遍helper，所以i又从0开始了，因为这句话The same repeated number may be chosen from C unlimited number of times.
helper({2,3,6,7}, target: 3, temp: size = 2) //这时里面的元素是2，2
helper({2,3,6,7}, target: 1, temp: size = 3) //这时里面的元素是2，2，2
helper({2,3,6,7}, target: -1, temp: size = 3 //当再次放了个2， target变成-1，说明不符合要求 返回 移走一个2
helper({2,3,6,7}, target: -2, temp: size = 4 // 2，2，2 i 变成了1， 所以是2，2，2，3 tareget = -2不符合要求 再return 
helper({2,3,6,7}, target: -5, temp: size = 4 //又变成2，2，2 但是这次加了nums[i =2] 进去 再return
helper({2,3,6,7}, target: -6, temp: size = 4 //2，2，2，7 还是不对 再return 7也被remove掉了
//这个循环都做了一遍，所以返回上一层的helper,接下来再remove掉一个，变成了2，2，这是i = 1
helper({2,3,6,7}, target: 0, temp: size = 3 //2,2,3,这是target = 0了，加入一个结果

/*


public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        // 先将数组排序避免重复搜素
        Arrays.sort(candidates);
        combinationSum(candidates, temp, 0, target, res);
        return res;
    }
    
    private void combinationSum(int[] nums,List<Integer> temp, int index, int target, List<List<Integer>> res){
      // 如果当前和已经大于目标，说明该路径错误 
        if(target < 0){
            return;
        }else if(target == 0){       // 如果当前和等于目标，说明这是一条正确路径，记录该路径
            List<Integer> comb = new ArrayList<Integer>(temp);
            res.add(comb);              
        }else for(int i = index; i < nums.length; i++){          // 否则，对剩余所有可能性进行深度优先搜索
            temp.add(nums[i]);                                   // 典型的先加入元素，再进行搜索，递归回来再移出元素的DFS解法 
            combinationSum(nums, temp, i, target - nums[i],res);
            temp.remove(temp.size() - 1);
            }   
    }
}
