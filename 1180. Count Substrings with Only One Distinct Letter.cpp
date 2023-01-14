Given a string s, return the number of substrings that have only one distinct letter.

 

Example 1:

Input: s = "aaaba"
Output: 8
Explanation: The substrings with one distinct letter are "aaa", "aa", "a", "b".
"aaa" occurs 1 time.
"aa" occurs 2 times.
"a" occurs 4 times.
"b" occurs 1 time.
So the answer is 1 + 2 + 4 + 1 = 8.
Example 2:

Input: s = "aaaaaaaaaa"
Output: 55
 

Constraints:

1 <= s.length <= 1000
s[i] consists of only lowercase English letters.
  
class Solution {
public:
    int countLetters(string s) {
        int count = 0;
        int repeatingChar = 1;
        for(int i=1; i<s.size(); i++)
        {
            if(s[i-1] != s[i])
            {
                count += repeatingChar * (repeatingChar + 1) / 2;
                repeatingChar = 0;
            }
            repeatingChar++;
        }
        return count + repeatingChar * (repeatingChar + 1) / 2;
    }
};
