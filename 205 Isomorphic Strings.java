/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
*/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        int len1 = t.length();
        if(len!=len1){
            return false;
        }
        HashMap<Character, Character> hm = new HashMap<Character, Character>();
        for(int i=0;i<len;i++){
            if(hm.containsKey(s.charAt(i))){
                if(hm.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else if(hm.containsValue(t.charAt(i))){
                return false;
            }else{
                hm.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
}


public class Solution {
    public boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512]; //record the last appeared position of each letter
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }
}
