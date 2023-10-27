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

class Node implements Comparable<Node>{
    int node;
    int cost;
    
    public Node(){
        
    }
    
    public Node(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node otherNode){
        if(this.cost < otherNode.cost)
            return -1;
        if(this.cost > otherNode.cost)
            return 1;
        return 0;
    }
}

class Solution{
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
		
		int dist[] = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		minHeap.add(new Node(S, 0));
		dist[S] = 0;
		
		while(minHeap.size() > 0){
		    Node currNode = minHeap.poll();
		    int u = currNode.node;
		    for(ArrayList<Integer> adjNode : adj.get(u)){
		        int v = adjNode.get(0);
		        int wt = adjNode.get(1);
		        if((dist[u]+wt) < dist[v]){
		            dist[v] = dist[u] + wt;
		            minHeap.add(new Node(v, dist[v]));
		        } 
		    }
		}
		
		return dist;
    }
}

