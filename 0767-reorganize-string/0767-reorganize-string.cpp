class Solution {
public:
    string reorganizeString(string s) {
        vector<int> count(26,0);
        for(char ch : s){
            count[ch-'a']++;
        }
        
        priority_queue<pair<int,char>,
                       vector<pair<int,char>>,
                       less<pair<int,char>>> maxHeap;
        for(int i=0; i<26; i++){
            if(count[i]){
                maxHeap.push({count[i],i+'a'});
            }
        }
        
        string resStr;
        while(!maxHeap.empty()){
            auto first = maxHeap.top(); maxHeap.pop();
            if(resStr.empty() || first.second != resStr.back()){
                resStr.push_back(first.second);
                if(--first.first > 0){
                    maxHeap.push(first);
                }
            }else{
                if(maxHeap.empty()){
                    return "";
                }
                
                auto second = maxHeap.top(); maxHeap.pop();
                resStr.push_back(second.second);
                if(--second.first > 0){
                    maxHeap.push(second);
                }
                
                maxHeap.push(first);
            }
        }
        
        return resStr;
    }
};