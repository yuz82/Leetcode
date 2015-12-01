/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null){ return false;}
        ListNode pre = head;
        ListNode cur = head;
        while(cur.next!=null&&cur.next.next!=null){
            pre = pre.next;
            cur = cur.next.next;
            if(pre == cur){
                return true;
            }
        }
        return false;
    }
}
