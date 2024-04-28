class Solution {
public:
    int minimumAddedInteger(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size(), m = nums2.size();
        
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        
        int minNum = INT_MAX;
        
        for(int i = 0; i < n - 1; i++){
            for(int j = i+1; j < n; j++){
                int index = 0;
                bool diffFound = false;
                bool invalidDiff = false;
                int validDiff = INT_MAX;
                
                for(int k = 0; k < n; k++){
                    if(k != i && k != j){
                        if(diffFound == false){
                            validDiff = nums2[index] - nums1[k];
                            diffFound = true;
                        } else{
                            int tempDiff = nums2[index] - nums1[k];
                            if(tempDiff != validDiff){
                                invalidDiff = true;
                                break;
                            }
                        }
                        index++;
                    }
                }
                
                if(invalidDiff == false){
                    minNum = min(minNum, validDiff);
                }
            }
        }
        
        return minNum;
    }
};