class LRUCache {
    class Node { // doubly linkedlist
        Node prev;
        Node next;
        int key;
        int val;
    }
    
    public void deleteNode(Node node) {
        Node prevNode = node.prev;
        node.prev.next = node.next;
        node.next.prev = prevNode;
    }
    
    public void addNode(Node node){
        // update head
        node.prev = head;
        node.next = head.next;
        node.next.prev = node; 
        head.next = node;
    }
    
    Map<Integer, Node> cache;
    int maxCap;
    // keep in mind that these are dummy nodes!
    Node head = new Node();
    Node tail = new Node();
    
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        maxCap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            deleteNode(node); // remove the item from the doubly linked list and then add it to the front
            addNode(node);
            return cache.get(key).val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node != null){
            node.val = value;
            deleteNode(node);
            addNode(node);
        } else {
            if(cache.size() == maxCap){
                cache.remove(tail.prev.key);
                deleteNode(tail.prev);
            } 
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;

            cache.put(key, newNode);
            addNode(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */