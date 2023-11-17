//{ Driver Code Starts
// Initial Template for Java
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
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution{
    private static int time;
    
    private void findArticulationPoints(int currNode,
                                        int parent, 
                                        ArrayList<ArrayList<Integer>> adj,
                                        int disc[],
                                        int low[],
                                        boolean visited[],
                                        boolean isAp[]){
        disc[currNode] = low[currNode] = ++time;
        visited[currNode] = true;
        
        int child = 0;
        
        for(int adjNode : adj.get(currNode)){
            if(visited[adjNode] == false){
                findArticulationPoints(adjNode, currNode, adj, disc, low, visited, isAp);
                low[currNode] = Math.min(low[currNode], low[adjNode]);
                if(parent != -1 && low[adjNode] >= disc[currNode]){
                    isAp[currNode] = true;
                }
                child++;
            }else if(adjNode != parent){
                low[currNode] = Math.min(low[currNode], disc[adjNode]);
            }
        }
        
        if(parent == -1 && child > 1){
            isAp[currNode] = true;
        }
    }
    
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj){
        int disc[] = new int[V];
        int low[] = new int[V];
        boolean visited[] = new boolean[V];
        boolean isAp[] = new boolean[V];
        
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(visited, false);
        Arrays.fill(isAp, false);
        
        time = 0;
        int parent = -1;
        for(int node = 0; node < V; node++){
            if(visited[node] == false){
                findArticulationPoints(node, parent, adj, disc, low, visited, isAp);
            }
        }
        
        ArrayList<Integer> results = new ArrayList<Integer>();
        for(int node = 0; node < V; node++){
            if(isAp[node] == true){
                results.add(node);
            }
        }
        
        if(results.size() == 0){
            results.add(-1);
        }
        
        return results;
    }
}





