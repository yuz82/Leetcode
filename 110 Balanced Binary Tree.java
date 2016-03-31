/*
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in which 
the depth of the two subtrees of every node never differ by more than 1.
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
 
 //divide & conquer
 public class Solution {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root)!=-1;
    }
    
    public int maxDepth(TreeNode node) {
        if(node == null) { return 0; }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        if(left==-1 || right==-1 || Math.abs(left-right)>1) { return -1; }
        return 1 + Math.max(left, right);
    }
    
}
 
 
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }else {
            if(isBalanced(root.left) && isBalanced(root.right) && (Math.abs(getHeight(root.left)-getHeight(root.right)) <= 1 )){
                return true;
            }
            return false;
        }
    }
    
    public int getHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }else if(node.left==null && node.right==null){
            return 1;
        }
        return 1 + Math.max(getHeight(node.left),getHeight(node.right));
    }
    
}
