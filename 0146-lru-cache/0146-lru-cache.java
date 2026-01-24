import java.util.*;

class LRUCache {

    private int capacity;
    private Map<Integer, Integer> map;   // key -> value
    private LinkedList<Integer> dll;     // keys in LRU order

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dll = new LinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        // move key to most recently used
        dll.remove((Integer) key); // O(n) internally
        dll.addLast(key);

        return map.get(key);
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            // update value
            map.put(key, value);

            // move key to MRU
            dll.remove((Integer) key);
            dll.addLast(key);
            return;
        }

        if (map.size() == capacity) {
            // remove least recently used
            int lruKey = dll.removeFirst();
            map.remove(lruKey);
        }

        // insert new key
        map.put(key, value);
        dll.addLast(key);
    }
}
