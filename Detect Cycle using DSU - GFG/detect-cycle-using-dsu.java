//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.detectCycle(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class DisjointSet{
    private int parent[];
    private int rank[];
    
    public DisjointSet(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    
    public boolean union(int node1, int node2){
        int node1Parent = find(node1);
        int node2Parent = find(node2);
        
        if(node1Parent == node2Parent)
            return true;
        
        if(rank[node1Parent] < rank[node2Parent]){
            parent[node1Parent] = node2Parent;
        }else if(rank[node1Parent] > rank[node2Parent]){
            parent[node2Parent] = node1Parent;
        }else{
            parent[node1Parent] = node2Parent;
            rank[node2Parent]++;
        }
        
        return false;
    }
}

class Solution{
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj){
        DisjointSet dsu = new DisjointSet(V);
        
        Set<List<Integer>> st = new HashSet<>();
        
        for(int i = 0; i < V; i++){
            for(int adjNode : adj.get(i)){
                List<Integer> edge1 = Arrays.asList(i, adjNode);
                List<Integer> edge2 = Arrays.asList(adjNode, i);
                
                if(st.contains(edge1) || st.contains(edge2)){
                    continue;
                }
                
                if(dsu.union(i, adjNode)){
                    return 1;
                }
                
                st.add(edge1);
                st.add(edge2);
            }
        }
        
        return 0;
    }
}