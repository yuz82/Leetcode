/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null || l2==null){
            if(l1 == l2){
                return null;
            }else if(l1 == null){
                return l2;
            }else{
                return l1;
            }
        }
        ListNode newLn = new ListNode(-1);
        ListNode cur = newLn;
        while(l1!=null || l2!=null){
            if(l1==null){
                cur.next = l2;
                break;
            }else if(l2==null){
                cur.next = l1;
                break;
            }
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return newLn.next;
    }
}

