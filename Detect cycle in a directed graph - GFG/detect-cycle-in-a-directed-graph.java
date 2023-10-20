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


/*Complete the function below*/

class Solution {
    public boolean isCyclicUtil(int currNode, ArrayList<ArrayList<Integer>> adj, int color[]){
        if(color[currNode] == 0){
            color[currNode] = 1;
            for(int adjNode : adj.get(currNode)){
                if(color[adjNode] == 0){
                    if(isCyclicUtil(adjNode, adj, color))
                        return true;
                }else if(color[adjNode] == 1){
                    return true;
                }
            }
        }   
        
        color[currNode] = 2;
        
        return false;
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int color[] = new int[V];
        for(int i = 0; i < V; i++){
            if(color[i] == 0){
                if(isCyclicUtil(i, adj, color)){
                    return true;
                }
            }
        }
        return false;
    }
}