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

class Edge implements Comparable<Edge>{
    public int src;
    public int dest;
    public int wt;
    
    public Edge(int src, int dest, int wt){
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
    
    public int compareTo(Edge other){
        return this.wt - other.wt;
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges_[][]){
	    ArrayList<Edge> edges = new ArrayList<>();
	    
	    int src = 0, dest = 0, wt = 0;
	    for(int i = 0; i < E; i++){
	        src = edges_[i][0];
	        dest = edges_[i][1];
	        wt = edges_[i][2];
	        
	        edges.add(new Edge(src, dest, wt));
	    }
	    
	    Collections.sort(edges);
	    
	    DisjointSet dsu = new DisjointSet(V);
	    int ans = 0;
	    int noOfEdge = 0;
	    int index = 0;
	    
	    while(noOfEdge < (V-1) && index < edges.size()){
	        Edge currEdge = edges.get(index++);
	        
	        src = currEdge.src;
	        dest = currEdge.dest;
	        wt = currEdge.wt;
	        
	        if(dsu.union(src, dest) == false){
	            ans += wt;
	            noOfEdge++;
	        }
	    }
	   
	    return ans;
	}
}