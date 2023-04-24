class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int,vector<int>,less<int>> maxHeap;
        
        for(auto& stone : stones){
            maxHeap.push(stone);
        }
        
        while(maxHeap.size() > 1){
            int y = maxHeap.top(); maxHeap.pop();
            int x = maxHeap.top(); maxHeap.pop();
            
            if(x != y)
                maxHeap.push(y-x);
        }
        
        return maxHeap.size() == 0 ? 0 : maxHeap.top();
    }
};