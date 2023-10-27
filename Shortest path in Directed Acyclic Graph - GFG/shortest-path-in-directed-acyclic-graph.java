//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
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

class Solution {
    public int[] dijkstraAlgorithm(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
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
    
	public int[] shortestPath(int N,int M, int[][] edges) {
		ArrayList<ArrayList<ArrayList<Integer>>> adj = 
		      new ArrayList<ArrayList<ArrayList<Integer>>>();
		
		for(int i = 0; i < N; i++){
		    adj.add(new ArrayList<ArrayList<Integer>>());
		}
		
		for(int i = 0; i < M; i++){
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    
		    ArrayList<Integer> edge = new ArrayList<>();
		    edge.add(v);
		    edge.add(wt);
		    
		    adj.get(u).add(edge);
		}
		
		int dist[] = dijkstraAlgorithm(N, adj, 0);
		
		for(int i = 0; i < N; i++){
		    if(dist[i] == Integer.MAX_VALUE){
		        dist[i] = -1;
		    }
		}
		
		return dist;
	}
}