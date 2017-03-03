/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, 
is completely filled, and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.
*/

复杂度
时间 O(N) 空间 O(1)

思路
完全二叉树的一个性质是，如果左子树最左边的深度，等于右子树最右边的深度，说明这个二叉树是满的，即最后一层也是满的，则以该节点为根的树其节点一共有2^h-1个。如果不等于，则是左子树的节点数，加上右子树的节点数，加上自身这一个。

注意
这里在左节点递归时代入了上次计算的左子树最左深度减1，右节点递归的时候代入了上次计算的右子树最右深度减1，可以避免重复计算这些深度
做2的幂时不要用Math.pow，这样会超时。用1<<height这个方法来得到2的幂


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = getLeftHeight(root);
        int right = getRightHeight(root);
        if(left == right){
            return (1 << left) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private int getLeftHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int height = 0;
        while(root != null){
            height++;
            root = root.left;
        }
        return height;
        
    }
    private int getRightHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int height = 0;
        while(root != null){
            height++;
            root = root.right;
        }
        return height;
    }
}
