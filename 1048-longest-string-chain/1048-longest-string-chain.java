class Solution {
    Map<String, Integer> mp;

    public boolean isMatch(String str1, String str2){
        int n = str1.length(), m = str2.length();

        if(Math.abs(n - m) != 1)
            return false;

        int i = 0, j = 0;
        int diff = 0;

        while(i < n && j < m){
            if(str1.charAt(i) != str2.charAt(j)){
                diff++;
                j++;
            }else{
                i++;
                j++;
            }
        }

        while(j < m){
            diff++;
            j++;
        }

        return diff == 1;
    }

    public int solve(String[] words, int n, String str){
        if(mp.containsKey(str)){
            return mp.get(str);
        }

        int maxCount = 0;
        for(int i = 0; i < n; i++){
            if(words[i].length() > str.length() && isMatch(str, words[i]) == true){
                maxCount = Math.max(maxCount, 1+solve(words, n, words[i]));
            }
        }

        mp.put(str, maxCount);

        return maxCount;
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        int maxCount = 0;
        
        mp = new HashMap<>();

        for(int i = 0; i < n; i++){
            maxCount = Math.max(maxCount, solve(words, n, words[i]));
        }
        return maxCount+1;
    }
}








/*

            ["a","b","ba","bca","bda","bdca"].  - N
              |.  
            /
        /
    /
["a","b","ba","bca","bda","bdca"]              - N
          |
          /
        /
      /
  ["a","b","ba","bca","bda","bdca"]            -N
                  |
                /
            /
        /
["a","b","ba","bca","bda","bdca"]             -N
                            |
                            /
                        /
                    ["a","b","ba","bca","bda","bdca"]


 */