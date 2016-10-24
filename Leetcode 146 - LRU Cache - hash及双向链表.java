Leetcode 146 - LRU Cache.java

public class LRUCache {
    
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    //head 和 tail 都是 dummy
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        } 
        //remove the curr from the current position
        Node curr = map.get(key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        
        moveToHead(curr);
        return curr.value;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node toRemove = map.get(key);
            toRemove.next.prev = toRemove.prev;
            toRemove.prev.next = toRemove.next;
            
        } else {
            if(map.size() >= capacity){
                map.remove(tail.prev.key);
                tail.prev = tail.prev.prev;
                tail.prev.next = tail;
            }
        }
        
        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToHead(insert);
    }
    
    private void moveToHead(Node curr) {
        curr.next = head.next;
        head.next = curr;
        curr.next.prev = curr;
        curr.prev = head;
    }
}