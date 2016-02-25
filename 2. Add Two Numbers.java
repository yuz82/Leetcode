/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        int carry = 0;
        while(l1!=null || l2!=null){
            int sum = (l1!=null?l1.val:0) + (l2!=null?l2.val:0) + carry;
            if(sum>9){
                carry = sum / 10;
                node.next = new ListNode(sum%10);
            }else{
                carry = 0;
                node.next = new ListNode(sum%10);
            }
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
            node = node.next;
        }
        if(carry>0){
            node.next = new ListNode(carry);
        }
        return head.next;
    }
    
}
