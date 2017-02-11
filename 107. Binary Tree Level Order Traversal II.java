/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
/*

/*
Method
The same as the Binary Tree Level Order Traversal I, only to put every list in the first every time
/*

/*
Basic Java
res.add(0, list);
/*


public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            List<Integer> list = new ArrayList<Integer>();
            
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                list.add(cur.val);
                if(cur.left != null){
                    q.add(cur.left);
            }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
            res.add(0, list);
        }
        
        return res;
    }
}
