/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode first = new ListNode('$');
        first.next = head;
        while(head.next!=null){
            ListNode tmp  = head.next;
            head.next = head.next.next;
            tmp.next = first.next;
            first.next = tmp;
        }
        head = first.next;
        return head;
    }
}


//recursion
public ListNode reverseList(ListNode head) {
    return helper(null, head);
}

ListNode helper(ListNode reversed, ListNode remaining) {
    if(remaining==null) return reversed;
    ListNode tmp = remaining.next;
    remaining.next = reversed;

    return helper(remaining, tmp);
}
