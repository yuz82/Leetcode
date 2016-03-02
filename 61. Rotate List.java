/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0){ return head; }
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode walker = head;
        ListNode runner = head;
        int n = 1;
        while(walker.next!=null){
            n++;
            walker = walker.next;
        }
        int i = k % n;
        if(i==0){ return head; }
        while(i-->0){
            runner = runner.next;
        }
        walker = head;
        while(runner.next!=null){
            walker = walker.next;
            runner = runner.next;
        }
        ListNode tmp = walker.next;
        walker.next = null;
        first.next = tmp;
        runner.next = head;
        return first.next;
    }
}
