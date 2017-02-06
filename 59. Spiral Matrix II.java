/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
/*

/* 
Method
Exactly the same as the Spiral Martix with only small changes
/*

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int num = 1;
        int rowBegin = 0;
        int rowEnd = n -1;
        int colBegin = 0;
        int colEnd = n - 1;
        
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int i = colBegin; i <= colEnd; i++){
                matrix[rowBegin][i] = num++;   //change
            }
            rowBegin++;
            
            for(int i = rowBegin; i <= rowEnd; i++){
                matrix[i][colEnd] = num++;   //change 
            }
            colEnd--;
            
            for(int i = colEnd; i >= colBegin; i-- ){
                matrix[rowEnd][i] = num ++;   //change 
            }
            rowEnd--;
            
            
            for(int i = rowEnd; i >= rowBegin; i--  ){
                matrix[i][colBegin] = num++;     //change
            }
            colBegin++;
        }
        
        return matrix;
        
    }
}
