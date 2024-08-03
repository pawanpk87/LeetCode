//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Solution {
    private boolean isCyclicUtil(int currNode, 
                                 ArrayList<ArrayList<Integer>> adj, 
                                 boolean[] dfsStack, 
                                 boolean[] visited
                                 ) {
        if(visited[currNode] == false) {
            dfsStack[currNode] = true;
            visited[currNode] = true;
            
            for(int adjNode : adj.get(currNode)) {
                if(dfsStack[adjNode] == true) {
                    return true;
                } else {
                    if(isCyclicUtil(adjNode, adj, dfsStack, visited)) {
                        return true;
                    }
                }
            }
            
            dfsStack[currNode] = false;
        }
        
        return false;
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] dfsStack = new boolean[V];
        boolean[] visited = new boolean[V];
        
        for(int node = 0; node < V; node++) {
            if(visited[node] == false) {
                if(isCyclicUtil(node, adj, dfsStack, visited)){
                    return true;
                }
            }
        }
        
        return false;
    }
}