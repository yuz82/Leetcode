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
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null&&runner.next.next!=null){
            walker = walker.next;
            runner = runner.next.next;
            if(walker == runner){
                return true;
            }
        }
        return false;
    }
}

//recursive   point all nodes to head, if a certain node.next == head, there is a cycle, but it breaks the original list
class HasCycleInLinkedList{
   public boolean hasCycle(ListNode head){
       if(head == null || head.next == null) return false;
       if(head.next == head) return true;
       ListNode nextNode = head.next; 
       head.next = head;
       boolean isCycle = hasCycle(nextNode);
       return isCycle;
   }
}
