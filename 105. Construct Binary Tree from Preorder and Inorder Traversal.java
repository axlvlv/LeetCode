/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
/*

/*
Method
假设树的先序遍历是12453687，中序遍历是42516837。
这里最重要的一点就是先序遍历可以提供根的所在，而根据中序遍历的性质知道根的所在就可以将序列分为左右子树。
比如上述例子，我们知道1是根，所以根据中序遍历的结果425是左子树，而6837就是右子树。
接下来根据切出来的左右子树的长度又可以在先序便利中确定左右子树对应的子序列（先序遍历也是先左子树后右子树）。
根据这个流程，左子树的先序遍历和中序遍历分别是245和425，右子树的先序遍历和中序遍历则是3687和6837，我们重复以上方法，可以继续找到根和左右子树，
直到剩下一个元素。可以看出这是一个比较明显的递归过程，对于寻找根所对应的下标，我们可以先建立一个HashMap，
以免后面需要进行线行搜索，这样每次递归中就只需要常量操作就可以完成对根的确定和左右子树的分割。

Mark the first element of the preorder result as it is the root elment
Mark the root element in the inorder result
Root element will divide the inorder result into left sub tree and right sub tree
Draw the tree

inorder = {10,30,40,50,60,70,90}
preorder = {50,30,10,40,70,60,90}
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







