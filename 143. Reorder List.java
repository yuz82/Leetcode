/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) { return; }
        //get the middle of list
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null){
            runner = runner.next;
            if(runner.next!=null){
                runner = runner.next;
                walker = walker.next;
            }
        }
        //reverse the second half of list
        ListNode first = walker;
        ListNode head1 = walker.next;
        while(head1.next!=null){
            ListNode tmp = head1.next;
            head1.next = tmp.next;
            tmp.next = first.next;
            first.next = tmp;
        }
        //reconstruct list
        head1 = first.next;
        while(head1!=null){
            ListNode tmp = head1;
            head1 = head1.next;
            first.next = head1;
            tmp.next = head.next;
            head.next = tmp;
            head = tmp.next;
        }
    }
}
