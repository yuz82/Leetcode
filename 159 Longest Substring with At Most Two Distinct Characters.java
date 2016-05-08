import java.util.*;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

    /**
     * @param args the command line arguments
     */
    
    //hashmap    O(n) time
    public static int lengthOfLongestSubstringTwoDistinct(String str){
        int n = str.length();
        if(str==null || n==0) { return 0; }
        int max = 1;
        HashMap<Character, Integer> hm = new HashMap<>();
        int head = 0;
        for(int i=0;i<n;i++){
            char c = str.charAt(i);
            if(hm.containsKey(c)){
                int count = hm.get(c) + 1;
                hm.put(c, count);
            }else{
                while(hm.size()==2){
                    char peek = str.charAt(head++);
                    int count = hm.get(peek) - 1;
                    if(count==0) { hm.remove(peek); }
                    else{ hm.put(peek, count); }
                }
                hm.put(c, 1);
            }
            max = Math.max(max, i-head+1);
        }
        return max;
    }
    
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        //O(n)
        //first: the first position of a substring
        //last: the last different element
        //i: the current element
        int first = 0, last = -1, maxLen = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (last >= 0 && s.charAt(last) != s.charAt(i)) {
                maxLen = Math.max(i - first, maxLen);
                first = last + 1;
            }
            last = i - 1;
        }
        return Math.max(s.length() - first, maxLen);
    }

    public static void main(String[] a) {
        System.out.println(longestSub("eebceceeceecce"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("eebceceeceecce"));
    }
    
}


public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 1) return 0;
        HashMap<Character,Integer> index = new HashMap<Character,Integer>();
        int lo = 0;
        int hi = 0;
        int maxLength = 0;
        while(hi < s.length()) {
            if(index.size() <= 2) {
                char c = s.charAt(hi);
                index.put(c, hi);
                hi++;
            }
            if(index.size() > 2) {
                int leftMost = s.length();
                for(int i : index.values()) {
                    leftMost = Math.min(leftMost,i);
                }
                char c = s.charAt(leftMost);
                index.remove(c);
                lo = leftMost+1;
            }
            maxLength = Math.max(maxLength, hi-lo);
        }
        return maxLength;
    }
}
