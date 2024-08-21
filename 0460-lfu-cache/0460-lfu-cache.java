class Node {
    int key;
    int value;
    int freq;
    
    Node next;
    Node prev;
    
    public Node(int key, int value, int freq) {
        this.key = key;
        this.value = value;
        
        this.freq = freq;
        
        this.next = null;
        this.prev = null;
    }
}

class DLL {
    Node head;
    Node tail;
    int size;
    
    public DLL() {
        head = new Node(-1, -1, 0);
        tail = new Node(-1, -1, 0);
        
        head.next = tail;
        tail.prev = head;
        
        size = 0;
    }
    
    public void add(Node node) {
        Node headNextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNextNode;
        headNextNode.prev = node;
        size++;
    } 
    
    public void remove(Node node) {
        Node nextNode = node.next;
        node.prev.next = nextNode;
        nextNode.prev = node.prev;
        size--;
    }
    
    public Node removeLastNode() {
        if(size == 0) {
            return null;
        }
        Node tailPrevNode = tail.prev;
        remove(tailPrevNode);
        return tailPrevNode;
    }
}


class LFUCache {
    Map<Integer, Node> cache;
    Map<Integer, DLL> frequencies;
    int CAPACITY;
    int minFrequence;
    
    public LFUCache(int capacity) {
        cache = new HashMap<>();
        frequencies = new HashMap<>();
        
        this.CAPACITY = capacity;
        this.minFrequence = 1;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null) {
            return -1;
        }
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        
        if(node != null) {
            node.value = value;
            update(node);
            return;
        }
        
        if(CAPACITY == cache.size()) {
            DLL head = frequencies.get(minFrequence);
            Node removedNode = head.removeLastNode();
            cache.remove(removedNode.key);
        }
        
        minFrequence = 1;
        insertNode(key, value, 1);
    }
    
    private void insertNode(int key, int value, int freq) {
        frequencies.putIfAbsent(freq, new DLL());
        
        Node newNode = new Node(key, value, freq);
        
        cache.put(key, newNode);
        frequencies.get(freq).add(newNode);
    }
    
    private void update(Node node) {
        DLL oldList = frequencies.get(node.freq);
        oldList.remove(node);
        
        if(node.freq == minFrequence && oldList.size == 0) {
            minFrequence++;
        }
        
        node.freq++; 
        
        frequencies.putIfAbsent(node.freq, new DLL());
        frequencies.get(node.freq).add(node);
    }
}