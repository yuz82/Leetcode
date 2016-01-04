/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0){
            return 0;
        }
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    dp[i][j] = matrix[i][j] - 48;
                }else if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;
    }
}
