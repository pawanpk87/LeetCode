class Solution {
private:
    vector<int> getLeftSmall(vector<int>& arr){
        int n = arr.size();
        vector<int> resIndx;
        stack<int> st;
        for(int i = 0; i < n; i++){
            while(!st.empty() && arr[st.top()] >= arr[i]){
                st.pop();
            }
            if(st.empty()){
                resIndx.push_back(-1);
            } else{
                resIndx.push_back(st.top());
            }
            st.push(i);
        }
        return resIndx;
    }
    
    vector<int> getRightSmall(vector<int>& arr){
        int n = arr.size();
        vector<int> resIndx;
        stack<int> st;
        for(int i = n-1; i >= 0; i--){
            while(!st.empty() && arr[st.top()] >= arr[i]){
                st.pop();
            }
            if(st.empty()){
                resIndx.push_back(n);
            } else{
                resIndx.push_back(st.top());
            }
            st.push(i);
        }
        reverse(resIndx.begin(), resIndx.end());
        return resIndx;
    }
    
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        
        vector<int> leftSmall = getLeftSmall(heights);
        vector<int> rightSmall = getRightSmall(heights);
        
        int largestRectangle = 0;
        
        int w, h;
        for(int i = 0; i < n; i++){
            if(leftSmall[i] == -1){
                w = rightSmall[i];
            } else{
                w = rightSmall[i] - leftSmall[i] - 1;
            }
            h = heights[i];
            
            largestRectangle = max(largestRectangle, (w * h));
        }
        
        return largestRectangle;
    }    
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        int n = matrix.size(), m = matrix[0].size();
        int maxRectangle = 0;
        vector<int> heights(m, 0);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '0'){
                    heights[j] = 0;
                } else{
                    heights[j]++;
                }
            }
            maxRectangle = max(maxRectangle, largestRectangleArea(heights));
        }
        return maxRectangle;
    }
};