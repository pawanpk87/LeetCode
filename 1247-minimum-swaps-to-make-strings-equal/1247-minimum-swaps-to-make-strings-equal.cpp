class Solution {
public:
    int minimumSwap(string s1, string s2) {
        int x_y=0, y_x=0;
        for(int i=0; i<s1.size(); i++)
        {
            if(s1[i] == 'x' && s2[i] == 'y') x_y++;
            else if(s1[i] == 'y' && s2[i] == 'x') y_x++;
        }
        if(x_y%2 != y_x%2)
            return -1;
        return (x_y/2 + y_x/2)+(x_y%2) * 2;
    }
};