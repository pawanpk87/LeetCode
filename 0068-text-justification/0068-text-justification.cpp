class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        vector<string> lines;
        int left = 0;
        while(left < words.size()){
            int right = findRight(words, left, maxWidth);
            lines.push_back(getLine(words, left, right, maxWidth));
            left = right+1;
        }
        return lines;
    }
    
    int findRight(vector<string>& words, int left, int maxWidth){
        int right = left;
        int sum = words[right++].size();
        while(right < words.size() && 
              (sum+words[right].size()+1) <= maxWidth){
            sum += (words[right++].size()+1);
        }
        return right-1;
    }
    
    string getLine(vector<string>& words, int left, int right, int maxWidth){
        if(right - left == 0){
            return addSpace(words[left], maxWidth - words[left].size());
        }
        
        int totalSpace = maxWidth - wordsLength(words,left,right);
        int numOfSpace = right - left;
        int isLastLine = right == words.size()-1;
        
        string space = isLastLine ? " ": getSpace(totalSpace/numOfSpace);
        int rem = isLastLine ? 0 : totalSpace%numOfSpace;
        
        string line;
        
        for(int i=left; i<=right; i++){
            line += words[i];
            line += space;
            line += rem-- > 0 ? " ": "";
        }
        
        line = line.substr(0,maxWidth);
        
        if(line.size() < maxWidth){
            return addSpace(line,maxWidth - line.size());
        }
        
        return line;
    }
    
    int wordsLength(vector<string>& words, int left, int right){
        int len = 0;
        while(left <= right){
            len += words[left++].size();
        }
        return len;
    }
    
    string addSpace(string word, int size){
        while(size--){
            word.push_back(' ');
        }
        return word;
    }    
    
    string getSpace(int size){
        string space;
        while(size--){
            space.push_back(' ');
        }
        return space;
    }
};