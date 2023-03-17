struct TrieNode{
    vector<TrieNode*> children;
    bool isEnd;
    
    TrieNode(){
        children.resize(26,NULL);
        isEnd = false;
    }
};

class Trie {
private:
    TrieNode* rootNode;
public:
    Trie() {
        rootNode = new TrieNode();
    }
    
    void insert(string word) {
        TrieNode* currNode = rootNode;
        for(char ch : word){
            if(currNode->children[ch-'a'] == NULL){
                currNode->children[ch-'a'] = new TrieNode();
            }
            currNode = currNode->children[ch-'a'];
        }
        currNode->isEnd = true;
    }
    
    bool search(string word) {
        TrieNode* currNode = rootNode;
        for(char ch : word){
            if(currNode->children[ch-'a'] == NULL){
                return false;
            }
            currNode = currNode->children[ch-'a'];
        }
        return currNode->isEnd == true;
    }
    
    bool startsWith(string prefix) {
        TrieNode* currNode = rootNode;
        for(char ch : prefix){
            if(currNode->children[ch-'a'] == NULL){
                return false;
            }
            currNode = currNode->children[ch-'a'];
        }
        return true;
    }
};