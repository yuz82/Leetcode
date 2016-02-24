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
