/*
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
*/



public class Solution {
    private class Node{
        int sp, mp;  //single path, max path
        public Node(int sp, int mp){
            this.sp = sp; //return value can be 0, from root to any
            this.mp = mp;  //must be max, from any to any
        }
    }
    public int maxPathSum(TreeNode root) {
        Node res = helper(root);
        return res.mp;
    }
    
    public Node helper(TreeNode root){
        if(root==null) { return new Node(0, Integer.MIN_VALUE); }
        //divide
        Node left = helper(root.left), right = helper(root.right);
        
        //conquer
        //可以不包括点， 可以return 0，从root开始走到任意点的最大路径
        int sp = Math.max(0, Math.max(left.sp,right.sp)+root.val);
        //必须要有点，从任意点到任意点
        int mp = Math.max(Math.max(left.mp, right.mp), left.sp+right.sp+root.val);
        return new Node(sp, mp);
    }
    
}
