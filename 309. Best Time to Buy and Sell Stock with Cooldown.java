/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
*/

//dp
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<2){
            return 0;
        }
        int[] hold = new int[n];
        int[] unhold = new int[n];
        //initial
        hold[0] = -prices[0];
        unhold[0] = 0;
        hold[1] = Math.max(hold[0], unhold[0]-prices[1]);
        unhold[1] = Math.max(unhold[0], hold[0]+prices[1]);
        //loop
        for(int i=2;i<n;i++){
            hold[i] = Math.max(hold[i-1], unhold[i-2]-prices[i]); //continue buy, start a new transaction
            unhold[i] = Math.max(unhold[i-1], hold[i-1]+prices[i]); //not buy, sell
        }
        return unhold[n-1];
    }
}
