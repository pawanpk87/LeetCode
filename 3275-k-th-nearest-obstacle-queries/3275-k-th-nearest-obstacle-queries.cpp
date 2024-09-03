class Solution {
public:
    vector<int> resultsArray(vector<vector<int>>& queries, int k) {
        priority_queue<int> maxHeap;
        vector<int> res;
        for(auto& q : queries) {
            maxHeap.push(abs(q[0]) + abs(q[1]));
           
            if(maxHeap.size() < k) {
                res.push_back(-1);
            } else {
                if(maxHeap.size() == k) {
                    res.push_back(maxHeap.top());
                } else {
                    maxHeap.pop();
                    res.push_back(maxHeap.top());
                }
            }
        }
        return res;
    }
};