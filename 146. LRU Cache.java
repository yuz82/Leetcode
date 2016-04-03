/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.
*/

public class LRUCache {
    
    private class Node{
        int key, value;
        Node pre, next;
        public Node(int key, int value){
            this.key = key; 
            this.value = value;
            pre = null; next = null;
        }
    }
    
    private HashMap<Integer, Node> cache = new HashMap();
    private int capacity;
    private Node first = new Node(0, 0);
    private Node tail = new Node(0, 0);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        first.next = tail;
        tail.pre = first;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        append(node);
        return node.value;
    }
    
    public void set(int key, int value) {
        if(get(key)!=-1){
            cache.get(key).value = value;
            return;
        }
        if(cache.size() == capacity){
            cache.remove(first.next.key);
            first.next = first.next.next;
            first.next.pre = first;
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        append(newNode);
    }
    
    public void append(Node node){
        node.pre = tail.pre;
        tail.pre = node;
        node.pre.next = node;
        node.next = tail;
    }
}
