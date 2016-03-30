/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
 
//recursive, but change the structure of linked list
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) { return null; }
        ListNode walker = head;
        ListNode runner = head;
        ListNode first = new ListNode(0); first.next = head;
        ListNode pre = first;
        while(runner.next!=null){
            if(runner.next!=null){
                runner = runner.next;
            }
            if(runner.next!=null){
                pre = walker;
                walker = walker.next;
                runner = runner.next;
            }
        }
        if(head==runner){ return new TreeNode(head.val); }
        TreeNode root = new TreeNode(walker.val);
        root.right = sortedListToBST(walker.next); 
        pre.next = null;
        root.left = sortedListToBST(first.next);
        return root;
    }
    
}



public class Solution {
    ListNode node = null;
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) { return null; }
        node = head;
        ListNode tail = head;
        int size = 0;
        while(tail!=null){
            tail = tail.next;
            size++;
        }
        return builder(0, --size);
    }
    
    public TreeNode builder(int s, int e){
        if(s>e) { return null; }
        int mid = (s+e)/2;
        TreeNode left = builder(s, mid-1);
        TreeNode root = new TreeNode(node.val);
        root.left = left;
        node = node.next;
        root.right = builder(mid+1, e);
        return root;
    }
    
}
