/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence 
of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] state = new boolean[len+1];
        state[0] = true;
        for(int i=1;i<=len;i++){
            for(int j=0;j<i;j++){
                if(state[j]&&wordDict.contains(s.substring(j,i))){
                    state[i]=true;
                    break;
                }
            }
        }
        return state[len];
    }
}
