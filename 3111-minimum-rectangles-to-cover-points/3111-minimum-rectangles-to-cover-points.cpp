class Solution {
public:
    int minRectanglesToCoverPoints(vector<vector<int>>& points, int w) {
        map<int, int> freq;
        for(auto& point : points){
            freq[point[0]]++;
        }
        vector<int> tempPoint;
        for(auto& data : freq){
            tempPoint.push_back(data.first);
        }
        int count = 0;
        int n = tempPoint.size();
        
        if(w == 0){
            return n;
        }
        
        int i = 0, j = 1;
        while(j < n){
            if(tempPoint[j] - tempPoint[i] > w){
                count++;
                i = j++;
            } else{
                j++;
            }
        }
        count++;
        return count;
    }
};