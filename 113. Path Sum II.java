/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new ArrayList<Integer>());
        return res;
    }
    
    public void dfs(TreeNode root, int sum, List<Integer> list){
        if(root==null) { return; }
        list.add(root.val);
        if(root.left==null && root.right==null && root.val==sum){
            res.add(new ArrayList(list));
        }else{
            dfs(root.left, sum-root.val, list); 
            dfs(root.right, sum-root.val, list); 
        }
        list.remove(list.size()-1);
    }
}
