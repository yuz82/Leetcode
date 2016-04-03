/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(0,nums.length-1, nums);
    }
    
    public TreeNode bst(int start, int end, int[] nums){
        if(start>end){ return null; }
        if(start==end){ return new TreeNode(nums[start]); }
        int mid = (end-start)/2+start;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bst(start,mid-1,nums);
        root.right = bst(mid+1,end,nums);
        return root;
    } 
}
