/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
/*

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        queue.add(root);
        
        int curNum = 1, nextNum = 0;
        
        while(!queue.isEmpty()){
            TreeNode cur = queue.pop();
            curNum--;
            list.add(cur.val);
            
            if(cur.left != null){
                queue.add(cur.left);
                nextNum ++;
            }
            
            if(cur.right != null){
                queue.add(cur.right);
                nextNum++;
            }
            
            if(curNum == 0){
                res.add(list);
                curNum = nextNum;
                nextNum = 0;
                list = new ArrayList<Integer>();
            }
        }
        return res;
    }
}
