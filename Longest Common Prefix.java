/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(strs==null||n==0){return "";}
        String str = strs[0];
        for(int i=1;i<n;++i){
            int len = Math.min(strs[i].length(),str.length());
            int j=0;
            while(j<len&&str.charAt(j)==strs[i].charAt(j)){
                j++;
            }
            str = str.substring(0,j);
        }
        return str;
    }
}

//find from the end
public String longestCommonPrefix(String[] strs) {
    if(strs == null || strs.length == 0)    return "";
    String pre = strs[0];
    int i = 1;
    while(i < strs.length){
        while(strs[i].indexOf(pre) != 0)
            pre = pre.substring(0,pre.length()-1);
        i++;
    }
    return pre;
}
