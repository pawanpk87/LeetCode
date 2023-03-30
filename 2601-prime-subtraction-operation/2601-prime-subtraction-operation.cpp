class Solution {
private:
    vector<bool> calculatePrimeNumbers(int n){
        vector<bool> prime(n+1,true);
        prime[0] = prime[1] = false;
        for(int i=2; i<=n; i++){
            if(prime[i] == true){
                for(int j=i*i; j<=n; j+=i){
                    prime[j] = false;
                }
            }
        }
        return prime;
    }      
public:
    bool primeSubOperation(vector<int>& nums) {
        vector<bool> primeFlag = calculatePrimeNumbers(1005);
        
        vector<int> prime;        
        for(int i=0; i<primeFlag.size(); i++){
            if(primeFlag[i]){
                prime.push_back(i);
            }
        }
        
        int n = nums.size();
        
        vector<int> newNums(n,-1);
        
        newNums[n-1] = nums[n-1];
     
        for(int i=n-2; i>=0; i--){
            if(nums[i] < newNums[i+1]){
                newNums[i] = nums[i];
                continue;
            }            
            for(int p : prime){
                if(p >= nums[i]){
                    newNums[i] = nums[i];
                    break;
                }
                if(nums[i]-p < newNums[i+1]){
                    newNums[i] = nums[i]-p;
                    break;
                }
            }
        }
        
        for(int i=1; i<n; i++){
            if(newNums[i] <= newNums[i-1]){
                return false;
            }
        }
        
        return true;
    }
};