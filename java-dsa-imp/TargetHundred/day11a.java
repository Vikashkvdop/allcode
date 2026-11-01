package TargetHundred;


import java.util.HashMap;

class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        // Dummy head and tail to avoid null checks
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insertToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            // Remove least recently used (from tail)
            Node lru = tail.prev;
            remove(lru);
        }
        Node newNode = new Node(key, value);
        insertToFront(newNode);
    }

    // Helper: Remove a node from DLL and map
    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: Insert node right after head
    private void insertToFront(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
        
        public static void main(String[] args) {
            LRUCache cache = new LRUCache(2);

            cache.put(1, 1);
            cache.put(2, 2);
            System.out.println(cache.get(1)); // 1

            cache.put(3, 3); // evicts key 2
            System.out.println(cache.get(2)); // -1

            cache.put(4, 4); // evicts key 1
            System.out.println(cache.get(1)); // -1
            System.out.println(cache.get(3)); // 3
            System.out.println(cache.get(4)); // 4
        }
    

}


