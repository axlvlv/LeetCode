/*
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
/*

Recursive

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p,q);
    }
        
        private boolean helper(TreeNode p, TreeNode q){
            if(p == null && q == null) return true;
            if(p == null || q == null) return false;
            return (p.val == q.val) && helper(p.left, q.left) && helper(p.right, q.right);
        }
}

Iterative
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(p);
        queue.add(q);
        
        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.left);
            queue.add(t1.right);
            queue.add(t2.right);
        }
        return true;
        
    }
}
