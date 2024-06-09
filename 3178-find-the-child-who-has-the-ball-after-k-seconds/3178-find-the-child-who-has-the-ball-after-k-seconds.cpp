class Solution {
public:
    int numberOfChild(int n, int k) {
        bool right = true;
        int index = 0;
        while(k--){
            if(right){
                index++;
            } else{
                index--;
            }
            if(index == n-1 || index == 0){
                right = !right;
            }
        }
        return index;
    }
};