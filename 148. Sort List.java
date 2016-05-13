/*
Sort a linked list in O(n log n) time using constant space complexity.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
//merge sort
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) { return head; }
        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
    
    public ListNode findMid(ListNode head){
        ListNode walker = head, runner = head.next;
        while(runner!=null && runner.next!=null){
            walker = walker.next;
            runner = runner.next.next;
        }
        return walker;
    }
    
    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(left!=null && right!=null){
            if(left.val < right.val){
                cur.next = left;
                left = left.next;
                cur = cur.next;
            }else{
                cur.next = right;
                right = right.next;
                cur = cur.next;
            }
        }
        if(left!=null){
            cur.next = left;
        }
        if(right!=null){
            cur.next = right;
        }
        return dummy.next;
    }
}
