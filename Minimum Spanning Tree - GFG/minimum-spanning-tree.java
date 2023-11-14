//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends

class Edge{
    public int node;
    public int wt;
    
    public Edge(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}

class Solution{
    static int findMinSpanningTree(int V, ArrayList<ArrayList<Edge>> adjList){
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(new Comparator<Edge>(){
	        public int compare(Edge edge1, Edge edge2){
	            return edge1.wt - edge2.wt;
	        }
	    });
	    
	    boolean mstSet[] = new boolean[V];
	    int values[] = new int[V];
	    int parent[] = new int[V];
	    
	    for(int i = 0; i < V; i++){
	        values[i] = Integer.MAX_VALUE;
	        parent[i] = -1;
	        mstSet[i] = false;
	    }
	    
	    int src = 0;
	    values[src] = 0;
	    
	    minHeap.offer(new Edge(src, 0));
	    
	    int u, v, wt;
	    while(!minHeap.isEmpty()){
	        Edge currNode = minHeap.poll();
	        u = currNode.node;
	        
	        if(mstSet[u] == true){
	            continue;
	        }
	            
	        mstSet[u] = true;
	        
	        for(Edge adjNode : adjList.get(u)){
	            v = adjNode.node;
	            wt = adjNode.wt;
	            if(mstSet[v] == false && values[v] > wt){
	                values[v] = wt;
	                parent[v] = u;
	                minHeap.offer(new Edge(v, wt));
	            }
	        }
	    }
	    
	    int minCost = 0;
	    for(int i = 1; i < V; i++){
	        //System.out.println(parent[i] + " - "+i+" -> "+values[i]);
	        minCost += values[i];
	    }
	    
	    return minCost;
    }
    
	static int spanningTree(int V, int E, int edges[][]){
	    ArrayList<ArrayList<Edge>> adjList = new ArrayList<ArrayList<Edge>>();
	    for(int i = 0; i < V; i++){
	        adjList.add(new ArrayList<Edge>());
	    }
	    
	    int src, dest, wt;
	    for(int i = 0; i < E; i++){
	        src = edges[i][0];
	        dest = edges[i][1];
	        wt = edges[i][2];
	        adjList.get(src).add(new Edge(dest, wt));
	        adjList.get(dest).add(new Edge(src, wt));
	    }
	    
	    return findMinSpanningTree(V, adjList);
	}
}

