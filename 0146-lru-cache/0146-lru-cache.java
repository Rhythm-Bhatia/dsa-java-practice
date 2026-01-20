class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
        
        
        
    }
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer,Node>map=new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        functionremove(node);
        addlast(node);//to do
        return node.value;
        




        
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            functionremove(node);
            node.value=value;
            addlast(node);
            return;

        }
        if(map.size()==capacity){
            Node lru=head.next;
            functionremove(lru);
            map.remove(lru.key);

        }
        Node node=new Node(key,value);
        addlast(node);
        map.put(key,node);

    }
    public void addlast(Node node){
        tail.prev.next=node;
        node.next=tail;
        node.prev=tail.prev;
        tail.prev=node;
        
    }
    public void functionremove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */