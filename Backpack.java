/*
Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?

Note: You can not divide any item into small pieces.

Example
If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] nums) {
        int n = nums.length;
        if(n==0) { return 0; }
        boolean[][] dp = new boolean[n+1][m+1];  表示前i个物品，取出一些物品能否组成体积和为j的背包
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j] = false;
            }
        }
        dp[0][0] = true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(dp[i-1][j] || (j-nums[i-1]>=0)&&dp[i-1][j-nums[i-1]]){
                    dp[i][j] = true;
                }
            }
        }
        for(int i=m;i>=0;i--){
            if(dp[n][i]) { return i; }
        }
        return 0;
    }
}
