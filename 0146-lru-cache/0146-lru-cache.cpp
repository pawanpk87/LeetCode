class LRUCache {
private:
    struct Node{
        Node *next, *prev;
        int key, value;
        
        Node(int key, int value){
            this->key = key;
            this->value = value;
            next = prev = NULL;
        }
    };

    unordered_map<int, Node*> mp;
    int capacity;
    Node *LRUPtr, *MRUPtr;

public:
    LRUCache(int capacity) {
        this->capacity = capacity;
        LRUPtr = new Node(-1, -1);
        MRUPtr = new Node(-1, -1);
        LRUPtr->next = MRUPtr;
        MRUPtr->prev = LRUPtr;
    }
    
    int get(int key) {
        if(mp.find(key) == mp.end()){
            return -1;
        }
        
        int value = mp[key]->value;
        
        deleteNode(mp[key]);
        mp[key] = addNodeBeforeMRUPtr(key, value);

        return value;
    }
    
    void put(int key, int value) {
        if(mp.find(key) == mp.end()){
            if(mp.size() == capacity){
                Node* LRUNode = LRUPtr->next;
                deleteNode(LRUNode);
                mp.erase(LRUNode->key);
            }
        }else{
            deleteNode(mp[key]);
        }
        Node* newNode = addNodeBeforeMRUPtr(key, value);
        mp[key] = newNode;
    }

    Node* addNodeBeforeMRUPtr(int key, int value){
        Node* newNode = new Node(key, value);
        MRUPtr->prev->next = newNode;
        newNode->prev = MRUPtr->prev;
        newNode->next = MRUPtr;
        MRUPtr->prev = newNode;
        return newNode;
    }

    void deleteNode(Node* node){
        Node* prev = node->prev;
        Node* next = node->next;
        prev->next = next;
        next->prev = prev;
    }
};