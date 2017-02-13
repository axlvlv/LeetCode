/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
/*

/*
Method
The crucial observation to this problem is the tree’s root always coincides with the first element in preorder traversal. 
This must be true because in preorder traversal you always traverse the root node before its children. 
The root node’s value appear to be 7 from the binary tree above.

We easily find that 7 appears as the 4th index in the inorder sequence. 
(Notice that earlier we assumed that duplicates are not allowed in the tree, so there would be no ambiguity). 
For inorder traversal, we visit the left subtree first, then root node, and followed by the right subtree. 
Therefore, all elements left of 7 must be in the left subtree and all elements to the right must be in the right subtree.

We left out some details on how we search the root value’s index in the inorder sequence. 
How about a simple linear search? If we assume that the constructed binary tree is always balanced, 
then we can guarantee the run time complexity to be O(N log N), where N is the number of nodes. 
However, this is not necessarily the case and the constructed binary tree can be skewed to the left/right, 
which has the worst complexity of O(N2).

A more efficient way is to eliminate the search by using an efficient look-up mechanism such as hash table. 
By hashing an element’s value to its corresponding index in the inorder sequence, we can do look-ups in constant time. 
Now, we need only O(N) time to construct the tree, which theoretically is the most efficient way.

inorder = {10,     30,       40,   50,    60,      70,        90}
                root.left         root          root.right
preorder = {50,   30,        10,  40,    70,        60,  90}
           root  root.left             root.right
           
           inroot - instart = 一颗子树的长度
           
           pre: 7, (10, 4, 3, 1), (2, 8, 3)
           in: (4,10,3,1),7,(11,8,2)
           
           
The crucial observation to this problem is the tree’s root always coincides with the first element in preorder traversal.

              50
             /   \
            30   70                inorder: 10,30,40; preorder: 30,10,40
           / \   / \
          10 40 60  90             inorder: 60,70,90; preorder: 70,60,90
          
          这题的方法中设置了prestart, preend, instart, inend
          其中prestart一开始等于0，所以root是50，因为一开始是一整颗树，所以preend是preorder.length - 1;
          instart只要用preorder的root的值去找到hashmap中Inorder的位置，这里是3，inend 一开始也是inorder.length -1
          这里有一个numsleft = inroot - instart 这里是3- 0 = 3 就是子树的大小
          进入root.left，preorder的root.left 就是root的下一个点，所以prestart = prestart + 1, preend = prestart + numsleft
          instart还是instart,end就是root - 1
          对于right tree，prestart = preStart + numLeft + 1, preEnd还是preEnd; instart = inroot + 1, inEnd还是Inend
/
*
Complexity Analysis
We left out some details on how we search the root value’s index in the inorder sequence. 
How about a simple linear search? If we assume that the constructed binary tree is always balanced, 
then we can guarantee the run time complexity to be O(N log N), where N is the number of nodes. 
However, this is not necessarily the case and the constructed binary tree can be skewed to the left/right, 
which has the worst complexity of O(N2).

A more efficient way is to eliminate the search by using an efficient look-up mechanism such as hash table. 
By hashing an element’s value to its corresponding index in the inorder sequence, we can do look-ups in constant time. 
Now, we need only O(N) time to construct the tree, which theoretically is the most efficient way.
/*

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0){
            return null;
        }
        
        Map<Integer,Integer> inMap = new HashMap<Integer,Integer>();
        
        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }
    
    private TreeNode buildTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend, Map<Integer, Integer> inMap){
        if(prestart > preend || instart > inend) return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int inroot = inMap.get(root.val);
        int numsleft = inroot - instart;
        
        root.left = buildTree(preorder, prestart + 1, prestart + numsleft, inorder, instart, inroot - 1, inMap);
        root.right = buildTree(preorder, prestart + numsleft + 1, preend, inorder, inroot + 1, inend, inMap);
        
        return root;
    }
}







