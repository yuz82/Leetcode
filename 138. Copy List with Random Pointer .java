/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
 //hashmap
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) { return null; }
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<>();
        RandomListNode dummy0 = new RandomListNode(0); dummy0.next = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        while(head!=null){
            cur.next = new RandomListNode(head.label);
            hm.put(head, cur.next);
            cur = cur.next;
            head = head.next;
        }
        head = dummy0.next;
        while(head!=null){
            RandomListNode node = hm.get(head);
            node.random = hm.get(head.random);
            head = head.next;
        }
        return dummy.next;
    }
}


//reconstruct original list and split
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) { return null; }
        //RandomListNode dummy = new RandomListNode(0); dummy.next = head;
        RandomListNode dummy = head;
        //copy next   1->1'->2->2'->3->3'->NULL
        while(head!=null){
            RandomListNode node = new RandomListNode(head.label);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }
        //copy random
        head = dummy;
        while(head!=null){
            RandomListNode node = head.next;
            if(head.random!=null) { node.random = head.random.next; }
            head = node.next;
        }
        //split two lists
        head = dummy;
        RandomListNode newHead = head.next;
        while (head != null) {
            RandomListNode temp = head.next;
            head.next = temp.next;
            head = head.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        return newHead;
    }
}
