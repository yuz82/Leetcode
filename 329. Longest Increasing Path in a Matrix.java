/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/


//time limited exceed
public class Solution {
    int max = 0;
    int[][] matrix = null;
    int m = 0, n = 0;
    int[] x = {0,0,1,-1}; //up, down, right, left
    int[] y = {1,-1,0,0};
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if(matrix==null || m==0) { return 0; }
        int n = matrix[0].length;
        this.matrix = matrix;
        this.m = m; this.n = n;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                helper(i,j,1);
            }
        }
        return max;
    }
    
    public void helper(int i, int j, int tmp){
        for(int k=0;k<4;k++){
            int x1 = i + x[k], y1 = j + y[k];
            if(x1>-1 && x1<m && y1>-1 && y1<n){
                if(matrix[x1][y1] > matrix[i][j]){
                    max = Math.max(tmp+1,max);
                    helper(x1, y1, tmp+1);
                }
            }
        }
    }
}
