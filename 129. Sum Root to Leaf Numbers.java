/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
//recursive
public class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null) { return 0; }
        helper(root, 0);
        return sum;
    }
    
    public void helper(TreeNode root, int num){
        if(root.left==null && root.right==null){ 
            sum += num*10 + root.val; 
        }
        if(root.left!=null){
            helper(root.left, num*10 + root.val);
        }
        if(root.right!=null){
            helper(root.right, num*10 + root.val);
        }
    }
    
}
 
//DFS, but change the value of node
public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root==null) { return 0; }
        int sum = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(stack.size()!=0){
            TreeNode tmp = stack.pop();
            if(tmp.left==null && tmp.right==null) { sum += tmp.val; continue;}
            if(tmp.left!=null){
                tmp.left.val = tmp.val*10 + tmp.left.val;
                stack.push(tmp.left);
            }
            if(tmp.right!=null){
                tmp.right.val = tmp.val*10 + tmp.right.val;
                stack.push(tmp.right);
            }
        }
        return sum;
    }
}
