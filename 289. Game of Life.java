/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?

*/

//O(n^2) space
public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] newboard = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int lives = count(board, i, j);
                if(board[i][j]>0){
                    if(lives<2){
                        newboard[i][j] = 0;
                    }else if(lives<4){
                        newboard[i][j]++;
                    }else if(lives>3){
                        newboard[i][j] = 0;
                    }
                }else{
                    if(lives==3){
                        newboard[i][j] = 1;
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j] = newboard[i][j];
            }
        }
    }
    
    public int count(int[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;
        int[] num = {0,-1,1};
        int count = 0;
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                if(x!=0 || y!=0){
                    if(i+num[x]>-1 && j+num[y]>-1 && i+num[x]<m && j+num[y]<n && board[i+num[x]][j+num[y]]>0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}


//in-place 
public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        /* only need int 0-3
        00: dead<-dead
        01: dead<-live
        10: live<-dead
        11: live<-live
        */
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int lives = count(board, i, j);
                if(board[i][j]==1 && lives>=2 && lives<=3){
                    board[i][j] = 3;
                }
                if(board[i][j]==0 && lives==3){
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j] >>= 1;
            }
        }
    }
    
    public int count(int[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;
        int lives = 0;
        for(int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for(int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }
}
