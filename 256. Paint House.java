/*
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, 
costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... 
Find the minimum cost to paint all houses.

Note: All costs are positive integers.

Example
Given costs = [[14,2,11],[11,14,5],[14,3,10]] return 10
house 0 is blue, house 1 is green, house 2 is blue, 2 + 5 + 3 = 10
*/

public class Solution {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // Write your code here
        int n = costs.length;
        if(costs==null || n==0) { return 0; }
        int[] dp = new int[3], pre = new int[3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                dp[j] = costs[i][j] + getMin(pre, j);
            }
            pre = Arrays.copyOf(dp, 3);
        }
        return getMin(dp, -1);
    }
    
    public int getMin(int[] pre, int j){
        int min = Integer.MAX_VALUE;
        for(int k=0;k<3;k++){
            if(k!=j){
                min = Math.min(min, pre[k]);
            }
        }
        return min;
    }
}
