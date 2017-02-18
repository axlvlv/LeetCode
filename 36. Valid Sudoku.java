/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
/*

/*
Method
HashSet 用set.add()Adds the specified element to this set if it is not already present. 
More formally, adds the specified element e to this set if this set contains no element e2 such that (e==null ? e2==null : e.equals(e2)). 
If this set already contains the element, the call leaves the set unchanged and returns false.

对于行和列的遍历，要用两个for，遍历行boolean[i][j],遍历列boolean[j][i]
对于九宫格中的每个格子的表示
row的Index在i = 0-2的时候都是0，表示的时候加上j/3，正好是前三行的三个九宫格
在i = 3-5的时候都是1，第4-6行的九宫格
在i = 6-8时，正好是第7-9行的九宫格

row:0,0,0
col:0,1,2是竖着在循环的
Use this code to check:
    public  static void test() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print("row = ");
                System.out.println((i / 3) * 3 + j/3);
//                System.out.print("col = ");
//                System.out.println((i%3)*3 + j%3);

            }
        }
    }
/*

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null){
            return false;
        }
        
        for(int i = 0; i < 9; i++){
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> sub = new HashSet<>();
            for(int j = 0; j < 9; j++){
                //check for rows
                if(board[i][j] != '.' && !row.add(board[i][j])){
                    return false;
                }
                if(board[j][i] != '.' && !col.add(board[j][i])){
                    return false;
                }
                int rowIndex = (i/3)*3;
                int colIndex = (i%3)*3;
                if(board[rowIndex + j/3][colIndex + j%3] != '.' && !sub.add(board[rowIndex + j/3][colIndex + j%3])){
                    return false;
                }
            }
        }
        
        return true;
    }
}
