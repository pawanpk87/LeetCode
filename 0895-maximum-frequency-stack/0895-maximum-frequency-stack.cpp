class FreqStack {
private:
    unordered_map<int, int> freq;
    unordered_map<int, stack<int>> freqSt;
    int maxFreq;
public:
    FreqStack() {
        this->maxFreq = 0;
    }
    
    void push(int val) {
        maxFreq = max(maxFreq, ++freq[val]);
        freqSt[freq[val]].push(val);
    }
    
    int pop() {
        int maxFreqNum = freqSt[maxFreq].top(); 
        freqSt[maxFreq].pop();
        freq[maxFreqNum]--;
        if(freqSt[maxFreq].size() == 0){
            --maxFreq;
        }
        return maxFreqNum;
    }
};