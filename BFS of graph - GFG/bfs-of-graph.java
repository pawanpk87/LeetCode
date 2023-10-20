//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public void bfs(int currNode, ArrayList<ArrayList<Integer>> adj, boolean visited[], ArrayList<Integer> result){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(currNode);
        visited[currNode] = true;
        
        while(!q.isEmpty()){
            int level = q.size();
            while(level-- > 0){
                int node = q.poll();
                
                result.add(node);
                
                for(int adjNode : adj.get(node)){
                    if(!visited[adjNode]){
                        visited[adjNode] = true;
                        q.add(adjNode);
                    }
                }
            }
        }
    }
    
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean visited[] = new boolean[V];
        // for(int i = 0; i < V; i++){
        //     if(!visited[i]){
                bfs(0, adj, visited, result);
        //     }
        // }
        return result;
    }
}