/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

//binary search, treate as list
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(matrix==null || m==0) { return false; }
        int n = matrix[0].length;
        if(target<matrix[0][0] || target>matrix[m-1][n-1]) { return false; }
        int start = 0;
        int end = m*n-1;
        while(start<=end){
            int mid = (end-start)/2 + start;
            if(matrix[mid/n][mid%n]==target) { return true; }
            else if(matrix[mid/n][mid%n]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return false;
    }
}

//O(n)
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(matrix==null || m==0) { return false; }
        int n = matrix[0].length;
        if(target<matrix[0][0] || target>matrix[m-1][n-1]) { return false; }
        int row = m-1;
        for(int i=1;i<m;i++){
            if(target<matrix[i][0]){
                row = i-1;
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(target==matrix[row][i]){
                return true;
            }
        }
        return false;
    }
}
