/*Given a binary tree, return the preorder traversal of its nodes' values.*/

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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root!=null){
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }
}

//stack
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root!=null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while(!stack.isEmpty()){
                root = stack.pop();
                list.add(root.val);
                if(root.right!=null){
                    stack.push(root.right);
                }
                if(root.left!=null){
                    stack.push(root.left);
                }
            }
        }
        return list;
    }
}

//only put right node to stack
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null){
            list.add(root.val);
            if(root.right!=null){
                stack.push(root.right);
            }
            root = root.left;
            if(root==null&&!stack.isEmpty()){
                root = stack.pop();
            }
        }
        return list;
    }
}
