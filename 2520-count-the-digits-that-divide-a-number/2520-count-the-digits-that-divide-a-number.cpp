class Solution {
public:
    int countDigits(int num) {
        int prevNum=num;
        int count=0;
        while(num)
        {
            int d=num%10;
            if(prevNum%d == 0)
                count++;
            num/=10;
        }
        return count;
    }
};