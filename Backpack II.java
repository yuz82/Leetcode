/*
Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value can you put into the backpack?

Note: You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param items & values: Given n items with size items[i] and value values[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] items, int values[]) {
        // write your code here
        int n = items.length;
        if(n==0) { return 0; }
        int[] dp = new int[m+1];
        for(int i=0;i<n;i++){
            for(int j=m;j>=items[i];j--){
                dp[j] = Math.max(dp[j], dp[j-items[i]]+values[i]);
            }
        }
        int max = 0;
        for(int i=1;i<=m;i++){
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
