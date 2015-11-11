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
        if(nums==null){
            return null;
        }
        int start = 0;
        int end = nums.length-1;
        TreeNode root = null;
        return bst(start,end, root, nums);
    }
    
    public TreeNode bst(int start, int end, TreeNode root, int[] nums){
        if(start==end){
            root = new TreeNode(nums[start]);
        }else if(start<end){
            int index = (end-start)/2+start;
            root = new TreeNode(nums[index]);
            root.left = bst(start,index-1,root,nums);
            root.right = bst(index+1,end,root,nums);
        }else{
            return null;
        }
        return root;
    } 
}
