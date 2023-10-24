//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

class Solution{
    static int findNode(boolean sptSet[], int dist[], int V){
        int minIndex = -1;
        for(int i = 0; i < V; i++){
            if(sptSet[i] == false){
                if(minIndex == -1){
                    minIndex = i;
                }  
                else if(dist[i] < dist[minIndex]){
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
    
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        boolean sptSet[] = new boolean[V];
        int dist[] = new int[V];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[S] = 0;
        
        for(int i = 0; i < V-1; i++){
            int u = findNode(sptSet, dist, V);
            sptSet[u] = true;
            ArrayList<ArrayList<Integer>> adjNodes = adj.get(u);
            for(ArrayList<Integer> adjNode : adjNodes){
                int v = adjNode.get(0);
                int wt = adjNode.get(1);
                if(dist[u]+wt < dist[v]){
                    dist[v] = dist[u]+wt;
                }
            }
        }
        
        return dist;
    }
}

