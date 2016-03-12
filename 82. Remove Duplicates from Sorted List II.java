/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode pre = first;
        ListNode cur = head;
        while(cur!=null){
            cur = cur.next;
            while(cur!=null && pre.next.val==cur.val){
                cur = cur.next;
            }
            if(pre.next.next==cur){
                pre = pre.next;
            }else{
                pre.next = cur;
            }
        }
        return first.next;
    }
}
