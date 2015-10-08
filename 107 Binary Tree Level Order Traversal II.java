/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).
    3
   / \
  9  20
    /  \
   15   7
[
  [15,7],
  [9,20],
  [3]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int level = 0;
        levelOrder(list, root, level);
        return list;
    }
    
    public void levelOrder(List<List<Integer>> list, TreeNode root, int level){
        if(root!=null){
            if(level >= list.size()){
                list.add(0, new ArrayList<Integer>());
            }
            levelOrder(list,root.left,level+1);
            levelOrder(list,root.right,level+1);
            list.get(list.size()-level-1).add(root.val);
        }
    }
}
