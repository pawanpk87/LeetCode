class Node implements Comparable<Node>{
    int node;
    int weight;
    
    public Node(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node otherNode){
        if(this.weight < otherNode.weight)
            return -1;
        if(this.weight > otherNode.weight)
            return 1;
        return 0;
    }
}

class Solution {
    private int[] minDistances(List<List<Node>> adjList,int source) {
        int n = adjList.size();
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[] dist = new int[n];
       
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[source] = 0;
        q.add(new Node(source, 0));
        
        while(!q.isEmpty()) {
            Node currNode = q.poll();
            int u = currNode.node;
            for(Node adjNode : adjList.get(u)) {
                int v = adjNode.node;
                int w = adjNode.weight;
                if(dist[v] > (dist[u] + w)) {
                    dist[v] = dist[u] + w;
                    q.add(new Node(v, dist[v]));
                } 
            }
        }
        
        return dist;
    }
    
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Node>> adjList = new ArrayList<>();
        
        for(int i = 0; i < n; i ++) {
            adjList.add(new ArrayList<Node>());
        }
        
        int src, dest, weight;
        for(int[] edge : edges) {
            src = edge[0];
            dest = edge[1];
            weight = edge[2];
            
            adjList.get(src).add(new Node(dest, weight));
            adjList.get(dest).add(new Node(src, weight));
        }
        
        int city = -1;
        int minCitiesCount = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            int[] minDist = minDistances(adjList, i);
            
            int currCitiesCount = 0;
            for(int j = 0; j < minDist.length; j++) {
                if(j != i && minDist[j] <= distanceThreshold) {
                    currCitiesCount++;
                }
            }
            
            if(currCitiesCount <= minCitiesCount) {
                minCitiesCount = currCitiesCount;
                city = i;
            }
            
            
            // System.out.println(i +" -> ");
            // for(int d : minDist) {
            //     System.out.print(d+ " ");
            // }
            // System.out.println();
        }
        
        return city;
    }
}