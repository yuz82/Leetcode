/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

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
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
        
    }
    
    public boolean isValid(TreeNode root, long min, long max){
        if(root==null){
            return true;
        }else{
            if(root.val>=max||root.val<=min){
                return false;
            }
            return isValid(root.left,min,root.val)&&isValid(root.right,root.val,max);
        
        }
    }
}
