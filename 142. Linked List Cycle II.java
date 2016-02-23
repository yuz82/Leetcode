/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/

/*Explanation: 
  A is the distance from head to the node where the cycle begins, B is from that node to where walker stops,
  so the total distance walker goes is A+B, and the distance for runner is 2A+2B.
  N represents the distance for a cycle. We have: A+B+N = 2A+2B, so N = A+B.
  After walker and runner meet, A stops at B, and we need A, and A = N-B.
  So we use another node starts from head and goes util it meets walker.
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode walker = head, runner = head;
        do{
            if(runner==null || runner.next==null) { return null; }
            walker = walker.next;
            runner = runner.next.next;
        }while(runner!=walker);
        runner = head;
        while(walker!=runner){
            walker = walker.next;
            runner = runner.next;
        }
        return walker;
    }
}

//time limited exceed
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next == head) { return head; }
        ListNode first = new ListNode(0);
        first.next = head;
        while(head.next!=null){
            if(head.next == first){
                return head;
            }
            ListNode tmp = head.next;
            head.next = first;
            head = tmp;
        }
        return null;
    }
}
