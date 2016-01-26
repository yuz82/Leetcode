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
 
//in-order recursive
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


//binary search   dfs
public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }

        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) return 0;

        return 1 + countNodes(n.left) + countNodes(n.right);
    }



//using heap to sort TreeNode
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
    PriorityQueue<TreeNode> heap = new PriorityQueue<>(new Comparator<TreeNode>(){
            public int compare(TreeNode n1, TreeNode n2){
                if(n1.val>n2.val){
                    return -1;
                }else if(n1.val==n2.val){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
    int size = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){return -1;}
        size = k;
        helper(root);
        return heap.peek().val;
    }
    
    public void helper(TreeNode root){
        if(heap.size()==size){
            if(root.val<heap.peek().val){
                heap.poll();
                heap.add(root);
            }
        }else{
            heap.add(root);
        }
        if(root.left!=null) { helper(root.left); }
        if(root.right!=null) { helper(root.right); }
    }
    
}
