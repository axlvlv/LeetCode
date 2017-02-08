/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
/*

/*
Method
Use two stacks
So it will go like zigzag
Notice to new stack each time, and need two whiles becasue you can only add levels until each level of elements all pop out

/*
Bacis Java
stack.push();
stack.pop();
stack.isEmpty();
Stack<TreeNode> stack = new Stack<TreeNode>()
/*

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        if(root == null) return res;
        
        int level = 1;
        list.add(root.val);
        res.add(list);
        
        stack.push(root);
        while(!stack.isEmpty()){
            list = new ArrayList<Integer>();
            Stack<TreeNode> newstack = new Stack<TreeNode>();
            level++;
            while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(level %2 == 0){
                if(cur.right != null){
                    list.add(cur.right.val);
                    newstack.push(cur.right);
                }
                
                if(cur.left != null){
                    list.add(cur.left.val);
                    newstack.push(cur.left);
                }
                
            }else{
                if(cur.left != null){
                    list.add(cur.left.val);
                    newstack.push(cur.left);
                }
                
                if(cur.right != null ){
                    list.add(cur.right.val);
                    newstack.push(cur.right);
                }
            }
        }
            
            if(list.size() >0 ){
                res.add(list);
            }
            stack = newstack;
        }
        return res;
    }
}
