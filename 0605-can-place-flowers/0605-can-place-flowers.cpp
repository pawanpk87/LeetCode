class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int f) {
        int n = flowerbed.size();
        
        if(n==1 && flowerbed[0]==0 && f!=0)
            return true;
        
        int count = 0;
        
        for(int i=0; i<flowerbed.size(); i++){
            if(flowerbed[i] == 1) 
                i++;
            else{
                int left = i-1>=0 ? flowerbed[i-1] : -1;
                int right = i+1<n ? flowerbed[i+1] : -1;
                
                if((left == 0 && right == 0) ||
                   (left == -1 && right == 0) ||
                   (right == -1 && left == 0)
                  ){
                    flowerbed[i] = 1;
                    count++;
                    i++;                   
                }            
            }
        }
        
        return count>=f;
    }
};