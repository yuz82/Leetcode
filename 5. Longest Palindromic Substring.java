/*
Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(s==null || n==0){
            return "";
        }
        String longest = "";
        int max = 0;
        int pre = 0;
        int post = 0;
        for(int i=0;i<n;i++){
            pre = i-1;
            post = i+1;
            while(pre>-1 && post<n && s.charAt(pre)==s.charAt(post)){
                pre--; post++;
            }
            if((--post)-(++pre)+1 > max){
                max = post-pre+1;
                longest = s.substring(pre, post+1);
            }
            pre = i;
            post = i+1;
            while(pre>-1 && post<n && s.charAt(pre)==s.charAt(post)){
                pre--; post++;
            }
            if((--post)-(++pre)+1 > max){
                max = post-pre+1;
                longest = s.substring(pre, post+1);
            }
        }
        return longest;
    }
}
