class Node{
    int key;
    int value;
    Node next;
    
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    static final int PRIME_CONST = 31;
    static final int DEFAULT_SIZE = 1000000;
    Node table[];
    
    public MyHashMap() {
        table = new Node[DEFAULT_SIZE];
    }
    
    public void put(int key, int value) {
        int hash = hashCode(key);
        Node newNode = new Node(key, value);
        if(table[hash] == null){
            table[hash] = newNode;
        }else{
            // now update the value if key found
            Node currNode = table[hash];
            Node targetNode = null;
            while(currNode != null){
                if(currNode.key == key){
                    targetNode = currNode;
                    break;
                }
                currNode = currNode.next;
            }
            if(targetNode != null){
                targetNode.value = value;
            }else{
                newNode.next = table[hash];
                table[hash] = newNode;
            }
        }
    }
    
    public int get(int key) {
        int hash = hashCode(key);
        Node currNode = table[hash];
        while(currNode != null){
            if(currNode.key == key){
                return currNode.value;
            }
            currNode = currNode.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = hashCode(key);
        Node currNode = table[hash];
        Node prevNode = null;
        Node targetNode = null;
        while(currNode != null){
            if(currNode.key == key){
                targetNode = currNode;
                break;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        if(targetNode != null){
            if(prevNode == null){
                table[hash] = targetNode.next;
            }else{
                prevNode.next = targetNode.next;
            }
        }
    }
    
    public int hashCode(int key){
        return Integer.hashCode(key) % DEFAULT_SIZE;
    }
}
/*
    
*/