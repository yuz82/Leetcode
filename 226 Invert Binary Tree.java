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
    
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }else{
            TreeNode node = new TreeNode(root.val);
            node.right = invertTree(root.left);
            node.left = invertTree(root.right);
            return node;
        }
        
    }

}
