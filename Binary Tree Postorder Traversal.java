/*Given a binary tree, return the postorder traversal of its nodes' values.*/

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
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root!=null){
            if(root.left!=null){
                postorderTraversal(root.left);
            }
            if(root.right!=null){
                postorderTraversal(root.right);
            }
            list.add(root.val);
        }
        return list;
    }
    
}

//iteration
