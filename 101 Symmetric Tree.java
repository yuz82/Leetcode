/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)){
            return true;
        }
        return symmetric(root.left,root.right);
    }
    
    public boolean symmetric(TreeNode tn1, TreeNode tn2){
        if(tn1==null&&tn2==null){
            return true;
        }
        if((tn1==null&&tn2!=null)||(tn1!=null&&tn2==null)){
            return false;
        }
        if(tn1.val!=tn2.val){
            return false;
        }
        return symmetric(tn1.left,tn2.right)&&symmetric(tn2.left,tn1.right);
        
    }
    
    
public class Solution {
public boolean isSymmetric(TreeNode root) {
    if(root==null)
        return true;
    return isSame(root.left,root.right);
}
public boolean isSame(TreeNode n1,TreeNode n2){
    if(n1==null||n2==null)
        return n1==n2;
    return(n1.val==n2.val && isSame(n1.left,n2.right) && isSame(n1.right,n2.left));
}
}

    
}
