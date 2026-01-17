// class LRUCache {

//     public LRUCache(int capacity) {
        
//     }
    
//     public int get(int key) {
        
//     }
    
//     public void put(int key, int value) {
        
//     }
// }
class LRUCache {

    private int capacity;
    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            return;
        }

        if (map.size() == capacity) {
            int lruKey = map.keySet().iterator().next(); // first = LRU
            map.remove(lruKey);
        }

        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */