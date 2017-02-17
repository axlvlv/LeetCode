/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
/*

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n < k){
            return res;
        }
        combine(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }
    
    private void combine(List<List<Integer>> res, List<Integer> temp, int k, int n, int index){
        if(n < 0){
            return;
        }
        if(n == 0 && temp.size() == k){
            res.add(new ArrayList<Integer>(temp));
        }
        
        for(int i = index; i <= 9; i++){
            temp.add(i);
            combine(res, temp, k, n - i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
