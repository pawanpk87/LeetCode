class Solution {
public:
    bool doesAliceWin(string s) {
        int n = s.size();
        bool aice = true;
        int i = 0;
        while(i < n) {
            int aI = getValidIndexForAlice(s, i);
            if(aI == -1) {
                return false;
            }
            
            if(aI == n-1) {
                return true;
            }
            
            int bI = getValidIndexForBob(s, aI + 1);
            
            if(bI == -1) {
                return true;
            }
            if(bI == n-1) {
                return false;
            }
            
            i = bI + 1;
        }
        return false;
    }
    
    int getValidIndexForAlice(string s, int index) {
        int n = s.size();
        int prevValidIndex = -1;
        int vowelsCount = 0;
        for(int i = index; i < n; i++) {
            if(isVowel(s[i])) {
                vowelsCount++;
            }
            if(vowelsCount > 0 && vowelsCount%2 != 0) {
                prevValidIndex = i;
            }
        }
        return prevValidIndex;
    }
    
    int getValidIndexForBob(string s, int index) {
        int n = s.size();
        int prevValidIndex = -1;
        int vowelsCount = 0;
        for(int i = index; i < n; i++) {
            if(isVowel(s[i])) {
                vowelsCount++;
            }
            if(vowelsCount == 0 || vowelsCount%2 == 0) {
                prevValidIndex = i;
            }
        }
        return prevValidIndex;
    }
    
    bool isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
};