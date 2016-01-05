import java.util.*;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

    /**
     * @param args the command line arguments
     */
    
    
    public static int longestSub(String input) {
        int result = 0;
        int length = input.length();
        if (length <= 2) {
            return length;
        }
        int startIdx = 0;
        int endIdx = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (; endIdx < length; endIdx++) {
            char newEnd = input.charAt(endIdx);
            if (map.containsKey(newEnd)) {
                map.put(newEnd, map.get(newEnd) + 1);
            } else {
                map.put(newEnd, 1);
            }
            if (endIdx == length - 1 && map.size() <= 2) {
                endIdx = length;
            }
            result = Math.max(result, endIdx - startIdx);
            if (map.size() > 2) {
                while (map.size() > 2) {
                    char newStart = input.charAt(startIdx);
                    if (map.containsKey(newStart)) {
                        if (map.get(newStart) == 1) {
                            map.remove(newStart);
                        } else {
                            map.put(newStart, map.get(newStart) - 1);
                        }
                    }
                    startIdx++;
                }
            }
        }
        return result;
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

