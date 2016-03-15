/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode(0); first.next = head;
        ListNode walker = first;
        ListNode runner = head;
        while(n-->1){
            runner = runner.next;
        }
        while(runner.next!=null){
            walker = walker.next;
            runner = runner.next;
        }
        walker.next = walker.next.next;
        return first.next;
    }
}
 
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode pre = first;
        int p = 0;
        ListNode cur = head;
        int i = 1;
        while(cur != null){
            if(i-p>n){
                pre = pre.next;
                ++p;
            }
            cur = cur.next;
            ++i;
        }
        pre.next = pre.next.next;
        return first.next;
    }
}
