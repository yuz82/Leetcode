/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        if(m == 0) return res;
        int n = matrix[0].length;
        int row = 0, col = -1;
        int flag = 0; //0,1,2,3 : orientation to right, down, left, up
        int total = m*n;
        m--;
        while(total>0){
            if(flag==0){
                col++;
                int tmp = 0;
                while(tmp++<n){
                    res.add(matrix[row][col++]);
                    total--;
                }
                n--;col--;flag++;
            }else if(flag==1){
                row++;
                int tmp = 0;
                while(tmp++<m){
                    res.add(matrix[row++][col]);
                    total--;
                }
                m--;row--;flag++;
            }else if(flag==2){
                col--;
                int tmp = 0;
                while(tmp++<n){
                    res.add(matrix[row][col--]);
                    total--;
                }
                n--;col++;flag++;
            }else if(flag==3){
                row--;
                int tmp = 0;
                while(tmp++<m){
                    res.add(matrix[row--][col]);
                    total--;
                }
                m--;row++;
                flag = 0;
            }
        }
        return res;
    }
}


//solution 2
public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }

        return res;
    }
