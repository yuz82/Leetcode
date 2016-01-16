/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //note: node number
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        int count = 1;
        ListNode last = head;
        while(last.next!=null){
            count++;
            last = last.next;
        }
        ListNode first = new ListNode(0);
        first.next = head;
        for(int i=0;i<count;i++){
            if(i%2!=0){
                last.next = new ListNode(head.val);
                last = last.next;
                head.val = head.next.val;
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return first.next;
    }
}

//when it talks about node value
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        int count = 1;
        ListNode last = head;
        while(last.next!=null){
            count++;
            last = last.next;
        }
        ListNode first = new ListNode(0);
        first.next = head;
        while((count--)>0){
            if(head.val%2==0){
                last.next = new ListNode(head.val);
                last = last.next;
                head.val = head.next.val;
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return first.next;
    }
}
