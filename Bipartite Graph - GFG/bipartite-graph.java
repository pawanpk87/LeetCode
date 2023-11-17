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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Node{
    public int node;
    public int color;
    
    public Node(int node, int color){
        this.node = node;
        this.color = color;
    }
}

class Solution{
    private boolean isBipartiteUtil(int currNode, int color[], ArrayList<ArrayList<Integer>>adj){
        Queue<Node> q = new LinkedList<Node>();
        
        q.add(new Node(currNode, 1));
        color[currNode] = 1;
        
        int u, v, currColor;
        while(!q.isEmpty()){
            Node node = q.poll();
            u = node.node;
            currColor = node.color;
            for(int adjNode : adj.get(u)){
                v = adjNode;
                if(color[v] == currColor){
                    return false;
                }
                
                if(color[v] == -1){
                    color[v] = currColor == 1 ? 0 : 1;
                    q.add(new Node(v, color[v]));
                }
            }
        }
        
        return true;
    }
    
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj){
        int color[] = new int[V];
        Arrays.fill(color, -1);
        
        for(int node = 0 ; node < V; node++){
            if(color[node] == -1){
                if(isBipartiteUtil(node, color, adj) == false){
                    return false;
                }
            }
        }
        
        return true;
    }
}