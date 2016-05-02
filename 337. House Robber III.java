/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
     2
    / \
   1   3
    \   
     4   
Maximum amount of money the thief can rob = 4 + 3 = 7.
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
    public int rob(TreeNode root) {
        if(root==null) { return 0; }
        int rob = root.val;
        if(root.left!=null){
            rob += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right!=null){
            rob += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(rob, rob(root.left)+rob(root.right));
    }
}

//DP
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }
    
    //0: notrob   1:rob
    public int[] dp(TreeNode root){
        if(root==null){
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
