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
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int k = 1;
        int num = n*n;
        int row = 0, col = 0;
        int left = 0, right = n-1, top = 0, bottom = n-1;
        while(k<=num){ 
            //to right
            for(int i=left;i<=right;i++){
                res[top][i] = k++;
            }
            top++;
            //to bottom
            if(left>right || top>bottom){
                break;
            }
            for(int i=top;i<=bottom;i++){
                res[i][right] = k++;
            }
            right--;
            //to left
            for(int i=right;i>=left;i--){
                res[bottom][i] = k++;
            }
            bottom--;
            //to top
            if(left>right || top>bottom){
                break;
            }
            for(int i=bottom;i>=top;i--){
                res[i][left] = k++;
            }
            left++;
        }
        return res;
    }
}
