/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

//dynammic programming
public class Solution {
    public int numTrees(int n) {
        if(n<3){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        return dp[n];
    }
}
