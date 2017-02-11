/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is 
defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
/*

/*
Method
1.The first method checks whether the tree is balanced strictly according to the definition of balanced binary tree: 
the difference between the heights of the two sub trees are not bigger than 1, 
and both the left sub tree and right sub tree are also balanced. With the helper function depth()
/*





public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return(Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right));
        
    }
    
    private int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
