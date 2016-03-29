/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

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
    public ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(0); first.next = head;
        ListNode tail = first;
        int count = 0;
        while(head!=null){
            tail = tail.next;
            head = head.next;
            count++;
        }
        ListNode cur = first;
        while(count-->0){
            if(cur.next.val>=x){
                if(cur.next!=tail){  //if cur.next==tail, cur.next = cur.next.next will vanish the changed order nodes after origainal tail 
                    ListNode tmp = cur.next;
                    cur.next = cur.next.next;
                    tmp.next = tail.next;
                    tail.next = tmp;
                    tail = tail.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return first.next;
    }
}
