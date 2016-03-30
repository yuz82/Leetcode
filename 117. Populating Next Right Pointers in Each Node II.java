/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
 //recursive
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) { return; }
        TreeLinkNode cur = root;
        if(cur.left!=null){
            if(cur.right!=null){
                cur.left.next = cur.right;
            }else{
                cur.left.next = helper(cur);
            }
        }
        if(cur.right!=null){
            cur.right.next = helper(cur);
        }
        connect(root.right);  //先右再左，保证上一层的.next一定是完成链接的  如果先左再右，必须有while(cur!=null){ ... cur = cur.next; } 以保证上一层的.next全部完成连接
        connect(root.left);
    }
    
     public TreeLinkNode helper(TreeLinkNode root){
        TreeLinkNode node = root.next;
        while(node!=null){
            if(node.left!=null){ return node.left; }
            if(node.right!=null){ return node.right; }
            node = node.next;
        }
        return null;
    }
    
}

//iterative
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) { return; }
        TreeLinkNode first = new TreeLinkNode(0);
        TreeLinkNode pre = first;
        while(root!=null){
            if(root.left!=null){
                pre.next = root.left;
                pre = pre.next;
            }
            if(root.right!=null){
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if(root==null){
                root = first.next;
                first.next = null;
                pre = first;
            }
        }
    }
    
}


//my iterative solution
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) { return; }
        while(root!=null){
            TreeLinkNode nexthead = null;
            TreeLinkNode cur = root;
            while(cur!=null){
                if(cur.left!=null){
                    if(nexthead==null) { nexthead = cur.left; }
                    if(cur.right!=null){
                        cur.left.next = cur.right;
                    }else{
                        cur.left.next = helper(cur);
                    }
                }
                if(cur.right!=null){
                    if(nexthead==null) { nexthead = cur.right; }
                    cur.right.next = helper(cur);
                }
                cur = cur.next;
            }
            root = nexthead;
        }

    }
    
    public TreeLinkNode helper(TreeLinkNode root){
        TreeLinkNode node = root.next;
        while(node!=null){
            if(node.left!=null){ return node.left; }
            if(node.right!=null){ return node.right; }
            node = node.next;
        }
        return null;
    }
    
}
