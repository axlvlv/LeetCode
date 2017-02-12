/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
/*

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, long minValue, long maxValue){
        if(root == null){
            return true;
        }
        
        if(root.val >= maxValue || root.val <= minValue){
            return false;
        }
        
        return helper(root.left, minValue, root.val) && helper(root.right, root.val, maxValue);
    }
}

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
  
        while(root != null || !stack.isEmpty()){
            while(root != null){
            stack.add(root);
            root = root.left;
            }
            
            root = stack.pop();
            if(pre != null && root.val <= pre.val){
                return false;
            }
            pre = root;
            root = root.right;
        }
        
        return true;
        
    }
}
