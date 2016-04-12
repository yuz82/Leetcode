/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/

public class Solution {
    List<List<String>> res = new ArrayList();
    public List<List<String>> partition(String s) {
        
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j) && (j+1>i-1 || pal[j+1][i-1])){
                    pal[j][i] = true;
                }
            }
        }
        helper(s, pal, 0, 0, new ArrayList<String>());
        return res;
    }
    
    public void helper(String str, boolean[][] pal, int s, int i, List<String> list){
        int n = str.length();
        if(i>=n) { return; }
        if(pal[s][i]) { 
            List<String> tmp = new ArrayList(list); 
            tmp.add(str.substring(s,i+1));
            if(i==n-1) { res.add(new ArrayList(tmp)); }
            helper(str, pal, i+1, i+1, tmp);
        }
        helper(str, pal, s, i+1, list);
    }
}
