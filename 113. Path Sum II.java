/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
/*

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        List<Integer> list = new ArrayList<Integer>();
        helper(root, sum, list, res );
        return res;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res){
        list.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList<Integer>(list));
        }
        
        if(root.left != null){
            helper(root.left, sum - root.val, list, res);
        }
        
        if(root.right != null){
            helper(root.right, sum - root.val, list, res);
        }
        
        list.remove(list.size() - 1);
    
    }
}
