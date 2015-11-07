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

//bfs
public class Solution {
    
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode endOfLevel = root;
        int depth = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node.left==null&&node.right==null){
                return depth;
            }
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            if(node==endOfLevel){
                depth++;
                endOfLevel = (node.right==null?node.left:node.right);
            }
        }
        return depth;
    }

}
