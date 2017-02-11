/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
/*

/*
Method
递归法
复杂度
时间 O(b^(h+1)-1) 空间 O(h) 递归栈空间 对于二叉树b=2

思路
简单的二叉树遍历，遍历的过程中记录之前的路径，一旦遍历到叶子节点便将该路径加入结果中。

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        
        if(root == null){
            return res;
        }
        
        findPath(root, String.valueOf(root.val),res);
        return res;
    }
    
    private void findPath(TreeNode root, String path, List<String> res){
        if(root.left == null && root.right == null){
            res.add(path);
        }
        
        if(root.left != null){
            findPath(root.left, path + "->" + root.left.val, res);
        }
        
        if(root.right != null){
             findPath(root.right, path + "->" + root.right.val,res);
        }
    }
}



