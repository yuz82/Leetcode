/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
 //BFS
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) { return;}
        Queue<TreeLinkNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeLinkNode node = queue.poll();
                if(node.left!=null) { queue.offer(node.left); }
                if(node.right!=null) { queue.offer(node.right); }
                if(i==size-1) { node.next = null; break; }
                node.next = queue.peek();
            }
        }
    }
}

//DFS recursive  
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) { return;}
        if(root.left!=null){
            root.left.next = root.right;
        }
        if(root.right!=null && root.next!=null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}

//DFS 
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode level_start=root;
        while(level_start!=null){
            TreeLinkNode cur=level_start;
            while(cur!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;

                cur=cur.next;
            }
            level_start=level_start.left;
        }
    }
}
