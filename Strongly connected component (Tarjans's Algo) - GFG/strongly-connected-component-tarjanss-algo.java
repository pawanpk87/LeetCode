//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ptr = ob.tarjans(V, adj);

            for(int i=0; i<ptr.size(); i++)
            {
                for(int j=0; j<ptr.get(i).size(); j++)
                {
                    if(j==ptr.get(i).size()-1)
                        System.out.print(ptr.get(i).get(j));
                    else
                        System.out.print(ptr.get(i).get(j) + " ");
                }
                System.out.print(",");
            }
            System.out.println();
		}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{  
    private static int time = 0;
    
    private void findComponent(int currNode, 
                                int disc[], 
                                int low[], 
                                boolean visited[],
                                Stack<Integer> st,
                                ArrayList<ArrayList<Integer>> adj,
                                ArrayList<ArrayList<Integer>> results){
                                    
        disc[currNode] = low[currNode] = ++time;
        visited[currNode] = true;
        st.push(currNode);
        
        for(int adjNode : adj.get(currNode)){
            if(disc[adjNode] == -1){
                findComponent(adjNode, disc, low, visited, st, adj, results);
                low[currNode] = Math.min(low[currNode], low[adjNode]);
            }else if(visited[adjNode] == true){
                low[currNode] = Math.min(low[currNode], disc[adjNode]);
            }
        }
        
        if(low[currNode] == disc[currNode]){
            int tempNode = -1;
            ArrayList<Integer> comp = new ArrayList<Integer>();
            while(tempNode != currNode){
                tempNode = st.pop();
                comp.add(tempNode);
                visited[tempNode] = false;
            }
            Collections.sort(comp);
            results.add(comp);
        }                           
    }
    
    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj){
        int disc[] = new int[V];
        int low[] = new int[V];
        boolean visited[] = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(visited, false);
        
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        
        for(int node = 0; node < V; node++){
            if(disc[node] == -1){
                findComponent(node, disc, low, visited, st, adj, results);
            }
        }
        
        Collections.sort(results, new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
                return a.get(0) - b.get(0);
            }
        });
        
        return results;
    }
}