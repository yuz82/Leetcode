/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

//O(MN) space
public class Solution {
    int[][] visited = null; //0 for unvisited, 1 for visited
    
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(matrix==null || m==0) { return; }
        int n = matrix[0].length;
        this.visited = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0 && visited[i][j]==0){
                    visited[i][j] = 1;
                    helper(matrix, i,j);
                }
            }
        }
    }
    
    public void helper(int[][] matrix, int i, int j){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int x=0;x<m;x++){
            if(visited[x][j]==0){
                visited[x][j] = 1;
                if(matrix[x][j]==0){
                    helper(matrix, x, j);
                }else{
                    matrix[x][j] = 0;
                }
            }
        }
        for(int x=0;x<n;x++){
            if(visited[i][x]==0){
                visited[i][x] = 1;
                if(matrix[i][x]==0){
                    helper(matrix, i, x);
                }else{
                    matrix[i][x] = 0;
                }
            }
        }
    }
}


//O(1) space
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(matrix==null || m==0) { return; }
        int n = matrix[0].length;
        int col0 = 1; //if the first column should be set to 0
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0) {
                col0 = 0;
            }
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for(int i=m-1;i>-1;i--){
            for(int j=n-1;j>0;j--){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
            if(col0==0) { 
                matrix[i][0] = 0; 
            }
        }
    }
    
}
