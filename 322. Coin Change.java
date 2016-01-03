/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
*/

//dynamic programming
public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        int[] min = new int[amount+1];
        min[0] = 0;
        for(int i=1;i<=amount;i++){
            min[i] = Integer.MAX_VALUE;
        }
        for(int i=1;i<=amount;i++){
            for(int j=0;j<n;j++){
                if(coins[j]<=i && min[i-coins[j]]!=Integer.MAX_VALUE && min[i]>min[i-coins[j]]+1){
                    min[i] = min[i-coins[j]]+1;
                }
            }
        }
        if(min[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return min[amount];
    }
    
}
