/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/


//dynamic programming
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i!=0 || j!=0){
                    dp[i][j] = grid[i][j] + Math.min(i>0?dp[i-1][j]:Integer.MAX_VALUE, j>0?dp[i][j-1]:Integer.MAX_VALUE);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
