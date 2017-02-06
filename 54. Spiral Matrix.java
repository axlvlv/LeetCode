/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
/*

/*
Time Complexity
因为每个元素访问一次，所以时间复杂度是O(m*n)，m，n是分别是矩阵的行数和列数，空间复杂度是O(1)。
/*

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        
        if(matrix.length == 0){
            return res;
        }
       
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while(rowBegin <= rowEnd && rowBegin <= colEnd){
            //Traverse to Right and save the row
            for(int i = colBegin; i <= colEnd; i++){
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            
            //Traverse to down and save the right
            for(int i = rowBegin; i <= rowEnd; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            
             if (rowBegin <= rowEnd) {
            //Traverse to left and save down
            for(int i = colEnd; i >= colBegin; i--){
                res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            
             if (colBegin <= colEnd) {
                for(int i = rowEnd; i >= rowBegin; i--){
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }
}
