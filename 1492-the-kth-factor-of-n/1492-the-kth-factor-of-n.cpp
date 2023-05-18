class Solution {
public:
    int kthFactor(int n, int k) {
        for(int num = 1; num<sqrt(n); num++){
            if(n%num == 0 && --k == 0){
                return num;
            }
        }
        
        for(int num = sqrt(n); num>=1; num--){
            if(n%(n/num) == 0 && --k == 0){
                return n/num;
            }
        }
        
        return -1;
    }
};

/*
 n = 12  k = num
 
 [1,2,3,...n]
 
 n % currNum == 0
 
 
 
 n % (n/currNum) == 0 
 
 
 [1,2,3,4,5,6]
 
 12%1 == 0
 12%12 == 0
 
 12%2 == 0
 12%6 == 0
 
 .
 .
 . 
*/