/**
Given two strings S and T, determine if they are both one edit distance apart.
*/

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int i = 0, j = 0;
        while(i<s.length() || j<t.length()){
            if(i<s.length() && j<t.length() && s.charAt(i)==t.charAt(j)){
                ++i; ++j;
            }else if(helper(s, i+1, t, j) || helper(s, i, t, j+1) || helper(s, i+1, t, j+1)){
                return true;
            }else{
            	break;
            }
        }
        return false;
    }
    
    public boolean helper(String s, int i, String t, int j){
        if(i>s.length() || j>t.length()){ return false; }
        if(s.substring(i).equals(t.substring(j))){
            return true;
        }
        return false;
    }
}
