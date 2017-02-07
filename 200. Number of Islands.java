/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
/*

/*
Method
1D Union find
How to convert a 2D to 1D?
Assume m is the length of the column, n is the length of the row.
(x,y) -> xm + y = id;
How to convert a 1D to 2D？
x = id/m, y = id%m
转换为无向图

DFS、BFS。只要遍历一遍，碰到一个1，就把它周围所有相连的1都标记为非1，这样整个遍历过程中碰到的1的个数就是所求解。

/*

/*
Complexity Analyze
时间 O(NM) 空间 O(max(N,M)) 递归栈空间
/*

/*
Basic Java
grid.length 是确定了行数
grid[i].length是确定了这一行的列数
在不确定是不是正方形的时候，要用
for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++)
/*

public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        
        int count = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count ++;
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 ||i >= grid.length || j >= grid[i].length || grid[i][j] != '1') return;
        
        grid[i][j] = '0';
        
        dfs(grid, i+ 1, j);
        dfs(grid, i - 1,j);
        dfs(grid, i, j+ 1);
        dfs(grid, i, j -1);
    }
}



