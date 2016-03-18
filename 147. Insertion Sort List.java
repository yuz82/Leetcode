/*
Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        ListNode first = new ListNode(0); 
        while(head!=null){
            ListNode node = new ListNode(head.val);
            ListNode cur = first;
            while(true){
                if(cur.next==null || cur.next.val>=node.val){
                    node.next = cur.next;
                    cur.next = node;
                    break;
                }
                cur = cur.next;
            }
            head = head.next;
        }
        return first.next;
    }
}
