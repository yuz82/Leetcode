/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/


//solution 1 
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'&&!isValid(i,j,board)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(int i, int j, char[][] board){
        for(int k=0;k<9;k++){
            if(k!=i && board[k][j]==board[i][j]){
                return false;
            }
        }
        for(int k=0;k<9;k++){
            if(k!=j && board[i][k]==board[i][j]){
                return false;
            }
        }
        for(int m=0;m<3;m++){
            for(int n=0;n<3;n++){
                int tmpi = i / 3;
                int tmpj = j / 3;
                if(m+tmpi*3!=i || n+tmpj*3!=j){
                    if(board[i][j]==board[m+tmpi*3][n+tmpj*3]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

