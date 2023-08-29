class Solution {
public:
    int bestClosingTime(string customers) {
        int n = customers.size();

        vector<vector<int>> customersCount(n,vector<int>(2,0));
        
        for(int i=0, j=n-1; i<n; i++,j--){
            if(i == 0){
                customersCount[i][0] = customers[i] == 'N' ? 1 : 0;
            }else{
                customersCount[i][0] = customersCount[i-1][0] + (customers[i] == 'N' ? 1 : 0);
            }
            
            if(j == n-1){
                customersCount[j][1] = customers[j] == 'Y' ? 1 : 0;
            }else{
                customersCount[j][1] = customersCount[j+1][1] + (customers[j] == 'Y' ? 1 : 0);
            }    
        }

        int minPenalty = INT_MAX;
        int earliestHour = INT_MAX;
        
        for(int i=0; i<n; i++){
            int noCustomerCount =  customersCount[i][0];
            int customerCount = customersCount[i][1];

            int currPenalty = noCustomerCount + customerCount;
            
            if(customers[i] == 'N')
                currPenalty--;
            
            if(minPenalty > currPenalty){
                minPenalty = currPenalty;
                earliestHour = i;
            }
        }
        
        if(minPenalty > (customersCount[n-1][0])){
            earliestHour = n;
        }
        
        return earliestHour;
    }
};

/*

Examples: -
    Input: customers = "YYNY"
    Output: 2
            "YYNY"
             0123
              |
             penalty = 1

    Solutions:-
                1.) trying all possible ways
                2.) 

                       "YYNY"
                        |
    count of customers          count of customers who
    who haven't came            have came after 0th hour 
    before 0th hour             (1)
    (1)
*/