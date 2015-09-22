/*
Given two strings s and t, write a function to determine if t is an anagram of s.
For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false
anagram: 相同字母的重新组合
*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.isEmpty() && t.isEmpty()){
            return true;
        }
        int len = s.length();
        if( len != t.length()){
            return false;
        }
        
        int[] arr = new int[26];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for(int i=0;i<len;i++){
            arr[sc[i]-'a']++;
        }
        for(int i=0;i<len;i++){
            if( --arr[tc[i]-'a'] < 0 ){
                return false;
            }
        }
        return true;
        
    }
}

 public class Solution {
        public boolean isAnagram(String s, String t) {
            char[] schar = s.toCharArray();
            char[] tchar = t.toCharArray();
            Arrays.sort(schar);
            Arrays.sort(tchar);
            s = new String(schar);
            t = new String(tchar);
            return s.equals(t);
        }
    }
