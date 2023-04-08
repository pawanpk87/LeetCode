class Solution {

private:
    
    Node* buildGraph(Node* node,unordered_map<int,Node*>& prevNode)
    {
        if(node == NULL)
            return node;
        
        if(prevNode.find(node->val) != prevNode.end())
            return prevNode[node->val];
        
        Node* newNode=new Node(node->val,{});
        
        prevNode[node->val]=newNode;
                
        for(int i=0; i<node->neighbors.size(); i++)
        {
            Node* adjNode=node->neighbors[i];
            
            Node* newAdjNode=buildGraph(adjNode,prevNode);
            
            newNode->neighbors.push_back(newAdjNode);
        }
        
        return newNode;
    }
    
public:
    
    Node* cloneGraph(Node* node) {
        unordered_map<int,Node*> prevNode;
        return buildGraph(node,prevNode);
    }
};