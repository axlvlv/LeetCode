/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:https://leetcode.com/problems/island-perimeter/
/*

/* 
Method
loop over the matrix and count the number of islands;
if the current dot is an island, count if it has any right neighbour or down neighbour;
the result is islands * 4 - neighbours * 2

descriptions of this problem implies there may be an "pattern" in calculating the perimeter of the islands.
and the pattern is islands * 4 - neighbours * 2, since every adjacent islands made two sides disappeared(as picture below).
/*

public class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        
        int count = 0;
        int near = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    count ++;
                if(i + 1 < grid.length && grid[i + 1][j] == 1) near++;
                if(j + 1 < grid[i].length && grid[i][j + 1] == 1) near++;
                }
            }
        }
        
        return count * 4 - near*2;
    }
}
