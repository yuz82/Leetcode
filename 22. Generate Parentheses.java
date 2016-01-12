/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        if(n<1){
            return list;
        }
        generate(list, n, 0, "");
        return list;
    }
    
    //left_to_add: the number of left parentheses can be added
    //left_to_match: the number of left parentheses that haven't beed matched
    public void generate(List<String> list, int left_to_add, int left_to_match, String str){
        if(left_to_add==0 && left_to_match==0){
            list.add(str);
            return;
        }
        if(left_to_add==0 && left_to_match!=0){
            generate(list, left_to_add, left_to_match-1, str+")");
            return;
        }
        if(left_to_match==0){
            generate(list, left_to_add-1, left_to_match+1, str+"(");
        }else{
            generate(list, left_to_add-1, left_to_match+1, str+"(");
            generate(list, left_to_add, left_to_match-1, str+")");
        }
    }
}
