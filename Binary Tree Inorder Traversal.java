/*Given a binary tree, return the inorder traversal of its nodes' values.*/

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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null){
            if(root.left!=null){
                inorderTraversal(root.left);
            }
            list.add(root.val);
            if(root.right!=null){
                inorderTraversal(root.right);
            }
        }
        return list;
    }
}

//iteration
public class Solution {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root!=null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while(root!=null||!stack.isEmpty()){
                while(root!=null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop(); 
                list.add(root.val); 
                root = root.right;
            }
            
        }
        return list;
    }
}
