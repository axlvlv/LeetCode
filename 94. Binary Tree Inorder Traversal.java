/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
/*

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode cur = root;
        
        while(cur != null || !stack.isEmpty()){
            while(cur != null){             //不停的将左边的值全部加到stack中去
                stack.add(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();   //将最下面的left pop出来，加进去
            list.add(cur.val);
            cur = cur.right;  //如果还有右子树 则重复上面的过程，如果没有的话 则会反上去, stack pop上一层的左子树，也就是上一层的root
        }
        
        return list;
        
    }
}
