这是一道非常综合的题目，主要应用在操作系统的资源管理中。维护一个数据结构使得访问操作和插入删除操作都是O(1)复杂度
实现get和set功能，数组，O(1)，
对节点有的删除和插入操作，链表，O(1)，

一个hash表加上一个双向链表来实现。
hash表的key就是资源本身的key，value是资源的结点（包含key和value的信息）。把结点维护成一个双向链表构成的队列.
访问某一个结点:通过hash表和key来找到结点，取到相应的value。
删除或者插入结点时:通过hash表找到结点，然后通过双向链表和队列的尾结点把自己删除同时插入到队尾。



Leetcode别人写的例子：
这个队列其实是在确定下一个踢掉的是哪个哈～ 也就是least used是哪个，所以刚刚用到的应该放在队尾，然后当需要踢掉元素的时候从队头踢出～
public class LRUCache {  
    class Node  
    {  
        Node pre, next;  
        int key;  
        int val;  
        public Node(int key, int value)  
        {  
            this.key = key;  
            this.val = value;  
        }  
    }  
      
    private int capacity;  
    private int num;  
    private HashMap<Integer, Node> map;  
    private Node first, last;  
      
    public LRUCache(int capacity) {  
        this.capacity = capacity;  
        num = 0;  
        map = new HashMap<Integer, Node>();  
        first = null;  
        last = null;  
    }  
      
    public int get(int key) {  
        Node node = map.get(key);  
        if(node == null)  
            return -1;  
        else if(node!=last)  
        {  
            if(node == first)  
                first = first.next;  
            else  
                node.pre.next = node.next;  
            node.next.pre = node.pre;  
            last.next = node;  
            node.pre = last;  
            node.next = null;  
            last = node;  //Last的指针指向node
        }  
        return node.val;  
    }  
      
    public void set(int key, int value) {  
        Node node = map.get(key);  
        if(node != null)  
        {  
            node.val = value;  
            if(node!=last)  
            {  
                if(node == first)  
                    first = first.next;  
                else  
                    node.pre.next = node.next;  
                node.next.pre = node.pre;  
                last.next = node;  
                node.pre = last;  
                node.next = null;  
                last = node;  
            }  
        }  
        else   
        {  
            Node newNode = new Node(key,value);  
  
            if(num>=capacity)  
            {  
                map.remove(first.key);  
                first = first.next;  
                if(first!=null)  
                    first.pre = null;  
                else  
                    last = null;  
                num--;      
            }  
            if(first == null || last == null)  
            {  
                first = newNode;  
            }  
            else  
            {  
                last.next = newNode;  
            }  
            newNode.pre = last;  
            last = newNode;  
            map.put(key,newNode);  
            num++;  
        }  
  
    }  
}  


