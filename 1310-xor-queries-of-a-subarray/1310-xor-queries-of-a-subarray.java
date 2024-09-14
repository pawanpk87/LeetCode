class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        
        int[] prefixXOR = new int[n+1];
        
        for(int i = 0; i < n; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
        }
        
        int[] res = new int[queries.length];
        
        int l,r;
        for(int i = 0; i < queries.length; i++) {
            l = queries[i][0]; r = queries[i][1];
            res[i] = prefixXOR[r + 1] ^ prefixXOR[l];
        }
        
        return res;
    }
}


/*

        Bitwise XOR = ^
        
        if the input bits are same then result will false otherwise true
        
        0 
        0
        -
        0   


        1
        1
        -
        0
        
        0
        1
        -
        1
        
        0
        1
        -
        1
        
        
        
        
        [1,      3,      4,      8]
         0       1       2       3
        0001    0010    0110    1110
        
         1      1^3     1^3^4
         
         
         
                        3^4 = (1^3^4) ^ 1 = 
                        
                        
                    
*/