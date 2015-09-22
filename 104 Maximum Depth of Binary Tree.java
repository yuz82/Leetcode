/*
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
    public int maxDepth(TreeNode root) {
        if(root != null){
            int left = maxDepth(root.left) + 1;
            int right = maxDepth(root.right) + 1;
            return left>right? left : right;
        }else {
            return 0;
        }
    }
}

//one line solution
//return root==null?0:1+ Math.max(root.left==null?0:maxDepth(root.left),root.right==null?0:maxDepth(root.right));
