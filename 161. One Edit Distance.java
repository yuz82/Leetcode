/**
Given two strings S and T, determine if they are both one edit distance apart.
*/

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int i = 0, j = 0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)!=t.charAt(j)){
                if(s.length()<t.length()){
                    return s.substring(i).equals(t.substring(j+1));
                }else if(s.length()>t.length()){
                    return s.substring(i+1).equals(t.substring(j));
                }else{
                    return s.substring(i+1).equals(t.substring(j+1));
                }
            }
            ++i; ++j;
        }
        return Math.abs(s.length()-t.length())==1;
    }
    
}

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
