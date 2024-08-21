class Node {
    int key;
    int value;
    
    Node next;
    Node prev;
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        
        this.next = null;
        this.prev = null;
    }
    
    public int getKey(){
        return key;
    }
    
    public int getValue() {
        return value;
    }
}

class LRUCache {
    int CAPACITY;
    Map<Integer, Node> mp;
    Node firstNode, lastNode;

    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        
        mp = new HashMap<>();
        
        initializeLinkedList();
    }
    
    private void initializeLinkedList() {
        firstNode = new Node(-1, -1);
        lastNode = new Node(-1, -1);
        
        firstNode.next = lastNode;
        lastNode.prev = firstNode;
    }
    
    public int get(int key) {
        int value = -1;
        if(!mp.containsKey(key)) {
            return value;
        }
        Node node = mp.get(key);
        value = node.getValue();
        
        deleteNode(node);
        Node newNode = addNode(key, value);
        mp.put(key, newNode);
        
        return value;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)) {
            deleteNode(mp.get(key));
        } else {
            if(CAPACITY == mp.size()) {
                deleteLeastRecentlyUsedKey();
            }
        }
        Node node = addNode(key, value);
        mp.put(key, node);
    }
    
    private Node addNode(int key, int value) {
        Node newNode = new Node(key, value);
        Node tempNextNode = firstNode.next;
        newNode.prev = firstNode;
        newNode.next = tempNextNode;
        firstNode.next = newNode;
        tempNextNode.prev = newNode;
        return newNode;
    }
    
    private void deleteLeastRecentlyUsedKey() {
        Node leastRecentlyUsedKey = lastNode.prev;
        deleteNode(leastRecentlyUsedKey);
        mp.remove(leastRecentlyUsedKey.getKey());
    }
    
    private void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}