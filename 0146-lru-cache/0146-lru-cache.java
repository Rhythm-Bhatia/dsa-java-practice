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
    Node head;
    Node tail;
    HashMap<Integer,Node>map=new HashMap<>();
    
    int c;
    LRUCache(int capacity) {
        c=capacity;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        
        tail.prev=head;
        

    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        Node find=map.get(key);
        find.prev.next=find.next;
        find.next.prev=find.prev;
        // removelastse(find);
        
        addstartme(find);
        return find.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            node.prev.next=node.next;
            node.next.prev=node.prev;
            addstartme(node);
        }
        else{
            Node node=new Node(key,value);
            map.put(key,node);
            addstartme(node);

            if(map.size()>c){
                Node temp=tail.prev;
                map.remove(temp.key);
                temp.prev.next=temp.next;
                temp.next.prev=temp.prev;

            }
        }
    }
    
    public void addstartme(Node node){
        Node temp=head.next;
        head.next=node;
        node.prev=head;
        node.next=temp;
        temp.prev=node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */