/*
Given a string, find the length of the longest substring without repeating characters. 

For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
For "bbbbb" the longest substring is "b", with the length of 1.
*/
//O(N^2)
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

//O(n)
public int lengthOfLongestSubstring(String s) {
    int i = 0, j = 0, max = 0;
    Set<Character> set = new HashSet<>();

    while (j < s.length()) {
        if (!set.contains(s.charAt(j))) {
            set.add(s.charAt(j++));
            max = Math.max(max, set.size());
        } else {
            set.remove(s.charAt(i++));
        }
    }

    return max;
}
