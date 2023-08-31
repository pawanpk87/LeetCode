class Solution {
public:
    int minTaps(int n, vector<int>& ranges) {
        vector<int> reach(n+1,0);

        for(int i=0; i<=n; i++){
            int range = ranges[i];
            int left = max(0, i-range);
            int right = min(n, i+range);
            reach[left] = max(reach[left], right);
        }

        int tapsCount = 0;
        int currEnd = 0;
        int nextEnd = 0;

        for(int i=0; i<=n; i++){
            if(i > nextEnd)
                return -1;
                
            if(i > currEnd){
                tapsCount++;
                currEnd = nextEnd;
            }

            nextEnd = max(nextEnd, reach[i]);
        }

        return tapsCount;
    }
};