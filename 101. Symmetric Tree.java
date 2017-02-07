/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
/*

/*
Method
Recursive
Two trees are a mirror reflection of each other if:

Their two roots have the same value.
The right subtree of each tree is a mirror reflection of the left subtree of the other tree.


Iterative
We can also use iteration with the aid of a queue. 
Each two consecutive nodes in the queue should be equal, and their subtrees a mirror of each other. 
Initially, the queue contains root and root. Then the algorithm works similarly to BFS, with some key differences. 
Each time, two nodes are extracted and their values compared. 
Then, the right and left children of the two nodes are inserted in the queue in opposite order. 
The algorithm is done when either the queue is empty, or we detect that the tree is not symmetric
/*

/
*
Complexity Analysis
Recursive
Because we traverse the entire input tree once, the total run time is O(n), 
where n is the total number of nodes in the tree.

The number of recursive calls is bound by the height of the tree. 
In the worst case, the tree is linear and the height is in O(n). 
Therefore, space complexity due to recursive calls on the stack is O(n) in the worst case.

Iterative
Because we traverse the entire input tree once, the total run time is O(n), where nn is the total number of nodes in the tree.
There is additional space required for the search queue. 
In the worst case, we have to insert O(n)O(n) nodes in the queue. Therefore, space complexity is O(n)O(n).
/*

//Recursive
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root, root);
    }
    
    private boolean isMirror(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null){
            return true;
        }
        
        if(r1 == null || r2 == null){
            return false;
        }
        
        return (r1.val == r2.val) && isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left);
    }
}

//Iterative
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null ) return false;
            if(t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        
        return true;
    }
}
