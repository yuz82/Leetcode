/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/

public class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] left = new boolean[2*n];
        boolean[] right = new boolean[2*n];
        helper(0, col, left, right,n);
        return count;
    }
    
    public void helper(int row, boolean[] col, boolean[] left, boolean[] right, int n){
        if(row==n) { count++; }
        for(int i=0;i<n;i++){
            if(col[i] || left[row+i] || right[i-row+n]) { continue; }
            col[i]=true; left[row+i]=true;  right[i-row+n]=true;
            helper(row+1, col, left, right, n);
            col[i]=false; left[row+i]=false;  right[i-row+n]=false;
        }
    }
}
