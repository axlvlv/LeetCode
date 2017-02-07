/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
/*

/*
Method
Use BFS.This problem is similar to Number of Islands. 
In this problem, only the cells on the boarders can not be surrounded. 
So we can first merge those O's on the boarders like in Number of Islands and replace O's with '#', 
and then scan the board and replace all O's left (if any).
这道题是说一个O周围都是X那么这个O就得变成X。那么就可以发现四周这一圈如果有O肯定不能四周都被X包围，同时这个O也将会是潜在的内部的O的缺口
思路就是先对四周的O进行特殊处理，用BFS走，把所有这个O连接的O（包括这个O）都涂成#。这样子，对于原来的棋盘来说，
没有变成#的O就是四周没有被O污染的，四周都是X，那么对其变成X。而所有#就是那些原来是O但是不是四周都被X包围的，把它们再还原成O。
/*

/*
Basic Java
direction[][] is for searching the four directions of one point. 
Say for board[i][j], we should check board[i-1][j], board[i+1][j], board[i][j-1], board[i][j+1], 
but with direction array, we could write this process in a for-loop.

class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
1.逻辑与（&&），如果第一个操作数为false，那么结果肯定false，所以在这种情况下，将不会执行逻辑与后面的运算了，即发生了短路。 

2.逻辑或（||），如果第一个操作数为ture，那么结果肯定是ture，所以在这种情况下，将不会执行逻辑与后面的运算了，即发生了短路。 
一个运算中两个符号都有，记得要加括号
/*


public class Solution {
    class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        
        int row = board.length, col = board[0].length;
        
        int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if((i == 0 || i == row - 1 | j == 0 || j == col - 1) && board[i][j] == 'O'){
                    Queue<Point> queue = new LinkedList<Point>();
                    board[i][j] = '#';
                    queue.offer(new Point(i,j));
                    while(!queue.isEmpty()){
                        Point point = queue.poll();
                        for(int k = 0; k < 4; k++){
                            int x = direction[k][0] + point.x;
                            int y = direction[k][1] + point.y;
                            if(x >= 0 && x < row && y >= 0 && y < col && board[x][y] =='O'){
                                board[x][y] = '#';
                                queue.offer(new Point(x,y));
                            }
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
