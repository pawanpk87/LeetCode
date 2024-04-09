class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        int n = tickets.size();
        int time = 0;
        for(int i = 0; i < n; i++){
            if(i <= k){
                time += min(tickets[i], tickets[k]);
            }else{
                time += min(tickets[k] - 1, tickets[i]);
            }
        }
        return time;
    }
};