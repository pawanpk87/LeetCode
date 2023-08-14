class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int,vector<int>,greater<int>> minHeap;
        
        for(auto& num : nums){
            minHeap.push(num);
            if(minHeap.size() > k)
                minHeap.pop();
        }
        
        int kthlargetNum = minHeap.top();
        
        return kthlargetNum;
    }
};