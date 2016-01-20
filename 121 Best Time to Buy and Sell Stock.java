/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int tmp = 0;
        int max = 0;
        int len = prices.length;
        for(int i=1;i<len;i++){
            tmp = tmp + prices[i] - prices[i-1];
            if(tmp<0){
                tmp = 0;
            }
            if(tmp > max){
                max = tmp;
            }
        }
        return max;
    }
}

public class Solution {
    public int maxProfit(int[] prices) {
        int tmp = 0;
        int max = 0;
        int len = prices.length;
        for(int i=1;i<len;i++){
            tmp = Math.max(tmp + prices[i] - prices[i-1],0);
            max = Math.max(tmp, max);
        }
        return max;
    }
}
