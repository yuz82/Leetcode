/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

//in-place
/*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(matrix==null || n==0) {return;}
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                //switch row
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = tmp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                //switch i,j
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    
}

//out-place
public class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        if(matrix==null || m==0) {return;}
        int n = matrix[0].length;
        int[][] mtx = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mtx[i][j] = matrix[m-j-1][i];
            }
        }
        for(int i=0;i<m;i++){
            System.arraycopy(mtx, 0, matrix, 0, n);
        }
    }
}
