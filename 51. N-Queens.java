/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

public class Solution {
    List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] left = new boolean[2*n];
        boolean[] right = new boolean[2*n];
        List<String> list = new ArrayList();
        helper(0, col, left, right,n, list);
        return res;
    }
    
    public void helper(int row, boolean[] col, boolean[] left, boolean[] right, int n, List<String> list){
        if(row==n) { res.add(new ArrayList<String>(list)); return; }
        for(int i=0;i<n;i++){
            if(col[i] || left[row+i] || right[i-row+n]) { continue; }
            col[i]=true; left[row+i]=true;  right[i-row+n]=true;
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++) { sb.append('.'); }
            sb.setCharAt(i, 'Q');
            list.add(sb.toString());
            helper(row+1, col, left, right, n, list);
            list.remove(list.size()-1);
            col[i]=false; left[row+i]=false;  right[i-row+n]=false;
        }
    }
}
