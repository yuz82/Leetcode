/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
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
 
//recursive
public class Solution {
    int count = 0;
    int result = -1;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return result;
    }
    
    public void helper(TreeNode root){
        if(root.left!=null){
            helper(root.left);
        }
        count--;
        if(count==0){
            result = root.val;
        }
        if(root.right!=null){
            helper(root.right);
        }
    }
    
}
