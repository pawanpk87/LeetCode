class Solution {
public:
    int maxArea(vector<int>& height) {
        int maxArea=0;
        
        int left=0, right=height.size()-1;

        while(left < right)
        {
            int width=right - left;
            maxArea=max(maxArea,min(height[left],height[right]) * width);

            if(height[left] <= height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
};