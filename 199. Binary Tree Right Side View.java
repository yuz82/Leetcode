/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
 
//BFS
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root==null) { return res; }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(i==size-1) { res.add(node.val); }
                if(node.left!=null){ queue.offer(node.left); }
                if(node.right!=null){ queue.offer(node.right); }
            }
        }
        return res;
    }
}


//DFS
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root==null) { return res; }
        helper(root, res, 0);
        return res;
    }
    
    public void helper(TreeNode root, List<Integer> res, int depth){
        if(root==null) { return; }
        if(depth==res.size()) { res.add(root.val); }
        
        helper(root.right, res, depth+1);
        helper(root.left, res, depth+1);
    }
}
