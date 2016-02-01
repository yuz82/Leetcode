/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits==null || digits.length()==0){
            return res;
        }
        res.add("");
        String[] dict = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int n = digits.length();
        for(int i=0;i<n;i++){
            int num = digits.charAt(i)-'0';
            if(num>9 || num<2){
                continue;
            }
            int size = res.size();
            for(int j=0;j<size;j++){
                int len = dict[num-2].length();
                for(int k=0;k<len;k++){
                    StringBuilder sb = new StringBuilder(res.get(0));
                    sb.append(dict[num-2].charAt(k));
                    res.add(sb.toString());
                }
                res.remove(0);
            }
        }
        return res;
    }
}
