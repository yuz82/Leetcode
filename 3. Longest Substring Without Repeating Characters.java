/*
Given a string, find the length of the longest substring without repeating characters. 

For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        for(int i=0;i<n;i++){
            HashSet<Character> hs = new HashSet();
            hs.add(s.charAt(i));
            int j=i+1;
            for(;j<n;j++){
                if(hs.add(s.charAt(j))){ continue; }
                else{
                    break;
                }
            }
            max = Math.max(max, j-i);
        }
        return max;
    }
}
