/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/

public class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        if(path==null || n==0) { return ""; }
        String[] strs = path.split("/");
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack();
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()==0 || strs[i].equals(".")){ continue; }
            if(strs[i].equals("..")) { if(stack.size()>0) {stack.pop();} continue; }
            stack.push(strs[i]);
        }
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop()); sb.insert(0, "/");
        }
        return sb.length()==0?"/":sb.toString();
    }
}
