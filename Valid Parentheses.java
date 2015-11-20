/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if(len==0) return true;
        Stack<Character> stack = new Stack<Character>();
        char[] ch = s.toCharArray();
        for(char c: ch){
            if(c == '('){
                stack.push(c);
            }
            if(c == ')'){
                if(stack.empty() || stack.peek()!='('){
                    return false;
                }
                stack.pop();
            }
            if(c == '['){
                stack.push(c);
            }
            if(c == ']'){
                if(stack.empty() || stack.peek()!='['){
                    return false;
                }
                stack.pop();
            }
            if(c == '{'){
                stack.push(c);
            }
            if(c == '}'){
                if(stack.empty() || stack.peek()!='{'){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
}
