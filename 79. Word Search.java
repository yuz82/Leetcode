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

*/

//no extra space to store visited
public boolean exist(char[][] board, String word) {
    char[] w = word.toCharArray();
    for (int y=0; y<board.length; y++) {
        for (int x=0; x<board[y].length; x++) {
            if (exist(board, y, x, w, 0)) return true;
        }
    }
    return false;
}

private boolean exist(char[][] board, int y, int x, char[] word, int i) {
    if (i == word.length) return true;
    if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
    if (board[y][x] != word[i]) return false;
    board[y][x] ^= 256;
    boolean exist = exist(board, y, x+1, word, i+1)
        || exist(board, y, x-1, word, i+1)
        || exist(board, y+1, x, word, i+1)
        || exist(board, y-1, x, word, i+1);
    board[y][x] ^= 256;
    return exist;
}


public class Solution {
    int m = 0;
    int n = 0;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        if(board==null || m==0 || word==null || word.length()==0){ return false; }
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0) && visited[i][j]==false){
                    if(check(board, visited, i, j, word, 0)) { return true; }
                }
            }
        }
        return false;
    }
    
    public boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k){
        if(i>-1 && i<m && j>-1 && j<n){
        if(k<word.length() && board[i][j]==word.charAt(k) && visited[i][j]==false){
            if(k==word.length()-1) { return true; }
        
            int[] x = {0,0,1,-1}, y = {1,-1,0,0};
            visited[i][j] = true;
            for(int m=0;m<4;m++){
                if(check(board, visited, i+x[m], j+y[m], word, k+1)) { return true; }
            }
            visited[i][j] = false;
        }
        }
        return false;
    }
}
