/*
Given two binary trees, write a function to check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p!=null && q != null){
            if(isSameTree(p.left,q.left) && isSameTree(p.right,q.right)&& p.val==q.val ){
                return true;
            }
            return false;
        }else {
            return false;
        }
    }
}
/*
//discuss
public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null || q == null) return p == q; // if they are null at the same time

    if (p.val != q.val) return false;

    return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
}
*/
