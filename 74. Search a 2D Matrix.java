/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
/*

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null){
            return false;
        }
        
         if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length, n = matrix[0].length;
        
        int start = 0, end = m * n - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(matrix[mid/n][mid%n] == target){
                return true;
            }else if(matrix[mid/n][mid%n] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if(matrix[start/n][start%n] == target ){
            return true;
        }else if(matrix[end/n][end%n] == target){
            return true;
        }
        
        return false;
    }
}
