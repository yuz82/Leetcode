/**
There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?
*/
//O(nk)
public class Solution {
    public int minCostII(int[][] costs) {
        if(costs==null || costs.length==0){ return 0; }
        int n = costs.length;
        int k = costs[0].length;
        int min1 = -1, min2 = -1;
        for(int i=0;i<n;i++){
           int newmin1 = -1, newmin2 = -1;
           for(int j=0;j<k;j++){
        	   costs[i][j] += (min1!=-1&&min1!=j ? costs[i-1][min1] : (min2!=-1&&min2!=j ? costs[i-1][min2] : 0));
        	   if(newmin1==-1 || costs[i][j]<costs[i][newmin1]){ 
        		   if(newmin1!=-1){ //!!!!!!!!
        			   newmin2 = newmin1;
         		   }
        		   newmin1 = j; 
    		   }
        	   else if(newmin2==-1 || costs[i][j]<costs[i][newmin2]){ newmin2 = j; }
           }
           min1 = newmin1; 
           min2 = newmin2;
        }
        return min1==-1 ? 0 : costs[n-1][min1];
    }
    
}
//O(nkk)
public class Solution {
    public int minCostII(int[][] costs) {
        if(costs==null || costs.length==0){ return 0; }
        int n = costs.length;
        int k = costs[0].length;
        int[] dp = new int[k];
        for(int i=0;i<n;i++){
            int[] tmp = new int[k];
            for(int j=0;j<k;j++){
                tmp[j] = costs[i][j] + getMin(dp, j);
            }
            dp = Arrays.copyOf(tmp, k);
        }
        return getMin(dp, -1);
    }
    
    public int getMin(int[] dp, int i){
        int min = Integer.MAX_VALUE;
        for(int j=0;j<dp.length;j++){
            if(j!=i){
                min = Math.min(min, dp[j]);
            }
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}
