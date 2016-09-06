/**
A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]

Challenge:

Can you do it in time complexity O(k log mn), where k is the length of the positions?
*/

public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if(positions==null || positions.length==0){ return res; }
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int[] father = new int[m*n];
        Arrays.fill(father, -1);
        int count = 0;
        for(int[] arr : positions){
            int idx = arr[0]*n + arr[1];
            father[idx] = idx;
            ++count;
            for(int k=0;k<4;k++){
                int x = arr[0] + dirs[k][0], y = arr[1] + dirs[k][1];
                if(x<0 || x>=m || y<0 || y>=n || father[x*n+y]==-1){ continue; }
                int tmp = find(father, x*n+y);
                if(tmp!=idx){
                    father[tmp] = idx;
                    --count;
                }
            }
            res.add(count);
        }
        return res;
    }
    
    public int find(int[] father, int i){
        int parent = father[i];
        while(parent!=father[parent]){
            father[parent] = father[father[parent]];
            parent = father[parent];
        }
        return parent;
    }
}
