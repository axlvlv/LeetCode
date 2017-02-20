/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
/*

/*
Method
 这道题分析看，就是一个词，在一行出现也是true，一列出现也是true，一行往下拐弯也是true，
 一行往上拐弯也是true，一列往左拐弯也是true，一列往右拐弯也是true。所以是要考虑到所有可能性，
 基本思路是使用DFS来对一个起点字母上下左右搜索，看是不是含有给定的Word。还要维护一个visited数组，
 表示从当前这个元素是否已经被访问过了，过了这一轮visited要回false，因为对于下一个元素，当前这个元素也应该是可以被访问的。
/*

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0){
            return false;
        }
        
        boolean[][] used = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, word, i , j , used, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, boolean[][] used, int index){
        if(index == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || used[i][j] ||board[i][j] != word.charAt(index)){
            return false;
        }
        used[i][j] = true;
        
        boolean res = dfs(board, word, i + 1, j, used, index + 1) || dfs(board, word, i - 1, j, used, index + 1) 
        || dfs(board, word, i, j + 1,used, index + 1) || dfs(board, word, i, j-1, used, index + 1);
        
        used[i][j] = false;
        
        return res;
    }
}
