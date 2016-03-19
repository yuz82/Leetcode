/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE; 
        int unhold1 = 0, unhold2 = 0;
        for(int p : prices){
            unhold2 = Math.max(unhold2, hold2+p);
            hold2 = Math.max(hold2, unhold1-p);
            unhold1 = Math.max(unhold1, hold1+p);
            hold1 = Math.max(hold1, -p);
        }
        return unhold2;
    }
}
