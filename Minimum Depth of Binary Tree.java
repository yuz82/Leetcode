/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //iteration
public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left==0 || right==0) ? left+right+1 : Math.min(left,right)+1;
    }

}
//DFS
public class Solution {
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root,1);
        return min;
    }
    
    public void dfs(TreeNode root, int depth){
        if(root.left!=null){
            dfs(root.left, depth+1);
        }
        if(root.right!=null){
            dfs(root.right, depth+1);
        }
        if(root.left==null&&root.right==null){
            min = Math.min(min, depth);
        }
    }

}
