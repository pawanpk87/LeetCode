//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends

class Solution {
    void dfs(int grid[][], int i, int j,int n, int m){
        if(i>=0 && j>=0 && i<n && j<m && grid[i][j] == 1)
        {
            grid[i][j] = 0;
            dfs(grid, i, j+1, n, m);
            dfs(grid, i, j-1, n, m);
            dfs(grid, i+1, j, n, m);
            dfs(grid, i-1, j, n, m);
        }
    }
    
    int numberOfEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1)
                    dfs(grid, i, j, n, m);
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) count++;
            }
        }        
        
        return count;
    }
}
