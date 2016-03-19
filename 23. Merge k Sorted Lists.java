/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue( new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2){
                if(n1.val>n2.val) { return 1; }
                else if(n1.val== n2.val) { return 0; }
                else{ return -1; }
            }
        });
        for(ListNode node : lists){
            if(node!=null) { 
                heap.offer(node);
            }
        }
        ListNode first = new ListNode(0);
        ListNode tail = first;
        while(!heap.isEmpty()){
            tail.next = heap.poll();
            tail = tail.next;
            if(tail.next!=null){
                heap.offer(tail.next);
            }
        }
        return first.next;
    }
}
