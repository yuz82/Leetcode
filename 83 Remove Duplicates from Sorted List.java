/*
Given a sorted linked list, delete all duplicates such that each element appear only once.
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

        ListNode ln = head;
        while(ln!=null){ //for each node
            while(ln.next!=null && ln.val == ln.next.val){//for next node 
                ln.next = ln.next.next;
            }
            ln = ln.next;
        }
        return head;
    }
    
}


public class Solution {
    
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode ln = head;
        while(ln.next!=null){ //for each node
            if(ln.val == ln.next.val){//for next node 
                ln.next = ln.next.next;
            }else{
                ln = ln.next;
            }
        }
        return head;
    }
    
}
