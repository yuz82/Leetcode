/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/

//dynamic programming
public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];
        for(int i=0;i<=s.length();i++){
            dp[0][i] = 1;
        }
        for(int i=0;i<t.length();i++){
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)==t.charAt(i)){
                    dp[i+1][j+1] = dp[i][j] + dp[i+1][j];
                }else{
                    dp[i+1][j+1] = dp[i+1][j];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
    
}


//backtracking time limited exceed
public class Solution {
    int count = 0;
    public int numDistinct(String s, String t) {
        
        helper(s, 0, t, 0, 0, count);
        return count;
    }
    
    public void helper(String s, int i, String t, int j, int tmp, int count){
        if(tmp==t.length()) { count++; return; }
        if(i>=s.length() || j>=t.length()) { return; }
        
        if(s.charAt(i)==t.charAt(j)) {
            helper(s, i+1, t, j+1, tmp+1, count);
        }
        helper(s, i+1, t, j, tmp, count);
    }
}
