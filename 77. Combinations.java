/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
/*

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> list, int start, int n , int k){
        if(k == 0){
            res.add(new ArrayList<Integer>(list));
        }else{
            for(int i = start; i <= n; i++){
            list.add(i);
            backtrack(res, list, i + 1, n, k - 1);
            list.remove(list.size() - 1);
            }
        }
    }
}
