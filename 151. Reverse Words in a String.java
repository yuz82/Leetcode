/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

*/

public class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        int n = strs.length;
        StringBuilder sb = new StringBuilder();
        for(int i=n-1;i>-1;i--){
            if(!strs[i].equals("")){
                sb.append(strs[i]+" ");
            }
        }
        return sb.toString().trim();
    }
}
