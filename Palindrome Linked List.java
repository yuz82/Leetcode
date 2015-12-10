/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
        if(head==null) { return true; }
        ListNode walker = new ListNode(0);
        walker.next = head; 
        ListNode runner = new ListNode(0);
        runner.next = head;
        //let walker be in the middle of the list
        //let runner be the end of the list
        while(runner.next!=null){
            if(runner.next.next!=null){
                runner = runner.next.next;
            }else{
                runner = runner.next;
            }
            walker = walker.next;
        }
        if(runner==walker) { return true; }
        //reverse the last part of the list
        ListNode first = walker.next;
        while(first.next!=null){
            ListNode tmp = first.next;
            first.next = tmp.next;
            tmp.next = walker.next;
            walker.next = tmp;
        }
        //compare
        ListNode cur = head;
        walker = walker.next;
        while(walker != null){
            if(walker.val != cur.val){ return false; }
            walker = walker.next;
            cur = cur.next;
        }
        return true;
    }
}
