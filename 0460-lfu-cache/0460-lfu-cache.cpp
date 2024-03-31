class Node{
public:
    int key, value, count;
    Node *next, *prev;
    
    Node(int key, int value){
        this->key = key;
        this->value = value;
        this->count = 1;
        this->next = this->prev = NULL;
    }
};

class DLL{
private:
    Node *head, *tail;
public:
    int size;
    
    DLL(){
        this->head = new Node(-1, -1);
        this->tail = new Node(-1, -1);
        head->next = tail;
        tail->prev = head;
        this->size = 0;
    }
    
    void add(Node* node){
        head->next->prev = node;
        node->next = head->next;
        node->prev = head;
        head->next = node;
        size++;
    }
    
    void remove(Node* node){
        node->prev->next = node->next;
        node->next->prev = node->prev;
        size--;
    }
    
    Node* removeLastNode(){
        if(size == 0){
            return NULL;
        }
        Node* tailPrevNode = tail->prev;
        remove(tailPrevNode);
        return tailPrevNode;
    }
    
    void printList(){
        Node* node = head;
        while(node){
            cout<<node->key<<" ";
            node = node->next;
        }
        cout<<endl;
    }
};


class LFUCache {
private:
    unordered_map<int, Node*> nodeMap;
    unordered_map<int, DLL*> countMap;
    int capacity;
    int minFreq;
    int size;
public:
    LFUCache(int capacity) {
        this->capacity = capacity;
        this->minFreq = 1;
        this->size = 0;
    }
    
    int get(int key) {
        if(nodeMap.find(key) == nodeMap.end()){
            return -1;
        }
        updateNode(nodeMap[key]);
        return nodeMap[key]->value;
    }
    
    void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        if(nodeMap.find(key) != nodeMap.end()){
            Node* node = nodeMap[key];
            node->value = value;
            updateNode(node);
        } else{
            Node* node = new Node(key, value);
            nodeMap[key] = node;
            
            if(size == capacity){
                DLL *targetList = countMap[minFreq];
                Node* lastNode = targetList->removeLastNode();
                nodeMap.erase(lastNode->key);
                size--;
            }
            
            size++;
            minFreq = 1;
            
            DLL *newList = new DLL();
            if(countMap.find(node->count) != countMap.end()){
                newList = countMap[node->count];
            }
            newList->add(node);
            countMap[node->count] = newList;
        }
    }
    
    void updateNode(Node* node){
        DLL *oldList = countMap[node->count];
        oldList->remove(node);
        if(node->count == minFreq && oldList->size == 0){
            minFreq++;
        }
        node->count++;
        DLL *newList = new DLL();
        if(countMap.find(node->count) != countMap.end()){
            newList = countMap[node->count];
        }
        newList->add(node);
        countMap[node->count] = newList;
    }
};