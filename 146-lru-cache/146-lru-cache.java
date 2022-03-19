class LRUCache {
    class Node { // doubly linkedlist
        Node prev;
        Node next;
        int key;
        int val;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
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
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        maxCap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int result = -1;
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            result = node.val;
            deleteNode(node); // remove the item from the doubly linked list and then add it to the front
            addNode(node);
        }
        return result;
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
            Node newNode = new Node(key,value);
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