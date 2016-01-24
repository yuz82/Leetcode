/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/

public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(grid==null || m==0){
            return 0;
        }
        int n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    helper(i,j,m,n,grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void helper(int i, int j, int m, int n, char[][] grid){
        if(i>=0 && i<m && j>=0 && j<n){
            if(grid[i][j] == '1'){
                grid[i][j] = '0';
                helper(i-1,j,m,n,grid);
                helper(i+1,j,m,n,grid);
                helper(i,j-1,m,n,grid);
                helper(i,j+1,m,n,grid);
            }
        }
        
    }
}

//solution 2
public class NumberofIslands {
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};
    public static int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int islands = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j]=='1') {
                    explore(grid,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
    public static void explore(char[][] grid, int i, int j) {
        grid[i][j]='x';
        for(int d=0;d<dx.length;d++) {
            if(i+dy[d]<grid.length && i+dy[d]>=0 && j+dx[d]<grid[0].length && j+dx[d]>=0 && grid[i+dy[d]][j+dx[d]]=='1') {
                explore(grid,i+dy[d],j+dx[d]);
            }
        }
    }
}
