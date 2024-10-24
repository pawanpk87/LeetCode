//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int q = Integer.parseInt(S[1]);
            int k = Integer.parseInt(S[2]);
            int[] nums = new int[n];
            String[] S1 = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(S1[i]);
            int[][] Queries = new int[q][2];
            for(int i = 0; i < q; i++){
                String[] S3 = br.readLine().trim().split(" ");
                for(int j = 0; j < S3.length; j++){
                    Queries[i][j] = Integer.parseInt(S3[j]);
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.solveQueries(nums, Queries, k);
            for(int i = 0; i < ans.length; i++)
                System.out.println(ans[i]);
        }
    }
}

// } Driver Code Ends


class MyData {
    private int MAX = 100005;
    
    public static int BLOCK_SIZE = 318;
    
    private int[] arr;
    private int[] count;
    private int answer;
    
    public MyData() {
        this.arr = new int[MAX];
        this.count = new int[MAX];
        this.answer = 0;
    }
    
    public void setArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            this.arr[i] = arr[i];
        }    
    }
    
    public void add(int index, int k) {
        count[arr[index]]++;
        if(count[arr[index]] == k) {
            answer++;
        }
    }
    
    public void subtract(int index, int k) {
        count[arr[index]]--;
        if(count[arr[index]] == k - 1) {
            answer--;
        }
    }
    
    public int getAnswer() {
        return this.answer;
    }
}

class Query {
    public int l,r;
    public int index;
    
    public Query(int l, int r, int index) {
        this.l = l;
        this.r = r;
        this.index = index;
    }
}

class Solution {
    public int[] solveQueries(int[] nums, int[][] Queries, int k) {
        /*
                1   1   1   2   1   3
                0   1   2   3   4   5
                
                Mo's algorightm
                
                    blockSize = 3
                    
                    
                    1   1   1   2   1   3
                    0   1   2   3   4   5
                    ---------   ---------
                      b0            b1
                      
                      
                    
                    
                            
                        queries = {1, 5}, {2, 4}
                        
                        sortedQueries = {2, 4}, {1, 5}
                        
                        
                        kTimesAppearedNum = -1;
                        
                        currL = 0
                        currR = 0
                        
                        
                        iterate throug queries
                                L   R
                                
                                while currL > L
                                    remove(): update the kTimesAppearedNum
                                    currL--
                                
                                while currL < L
                                    add(): update the kTimesAppearedNum
                                    currL++
                                
                                while currR <= R
                                    remove(): update the kTimesAppearedNum
                                    currR++
                                
                                while currR > R
                                    remove(): update the kTimesAppearedNum
                                    currR--
                   
                   
            O(Q long q)
            O( Q * (S * n) )
            
            O( (N + Q) * F * sqrt(N))
            
        */
        
        int qn = Queries.length;
        
        // ================= Sort the queries ========================
        List<Query> queries = new ArrayList<>();
        for(int i = 0; i < qn; i++) {
            queries.add(new Query(Queries[i][0] - 1, Queries[i][1] - 1, i));
        }
        
        Collections.sort(queries, new Comparator<Query>(){
           public int compare(Query q1, Query q2) {
               int q1BlockNum = q1.l / MyData.BLOCK_SIZE;
               int q2BlockNum = q2.l / MyData.BLOCK_SIZE;
               
               if(q1BlockNum != q2BlockNum) {
                   return Integer.compare(q1.l, q2.l);
               }
               
               return Integer.compare(q1.r, q2.r);
           }
        });
        
        // =============== Mo's Algorith start =========================
        MyData data = new MyData();
        data.setArray(nums);
        
        int[] ans = new int[qn];
        
        int currL = 0;
        int currR = 0;
        
        for(int i = 0; i < qn; i++) {
            Query q = queries.get(i);
            int L = q.l;
            int R = q.r;
            int index = q.index;
            
            while(currL < L) {
                data.subtract(currL, k);
                currL++;
            }
            
            while(currL > L) {
                data.add(currL - 1, k);
                currL--;
            }
            
            while(currR <= R) {
                data.add(currR, k);
                currR++;
            }
            
            while(currR > R + 1) {
                data.subtract(currR - 1, k);
                currR--;
            }
            
            ans[index] = data.getAnswer();
        }    
        // =============== Mo's Algorith start =========================
        
        return ans;
    }
}