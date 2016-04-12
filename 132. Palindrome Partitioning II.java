/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/


//DP
public class Solution {
    //dp[i] = dp[j] + 1 | j<i && isPalindrome[j+1][i]==true
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] dp = new int[n];
        
        for(int i=0;i<n;i++){
            dp[i] = i;
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j) && (j+1>i-1 || isPalindrome[j+1][i-1])){
                    isPalindrome[j][i] = true;
                    dp[i] = j==0?0:Math.min(dp[i], dp[j-1]+1);
                }
            }
        }
        return dp[n-1];
    }
    
}
