/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val<root.val && q.val<root.val){
            root = root.left;
            return lowestCommonAncestor(root, p, q);
        }
        if(p.val>root.val && q.val>root.val){
            root = root.right;
            return lowestCommonAncestor(root, p, q);
        }
        return root;
            
    }
}
