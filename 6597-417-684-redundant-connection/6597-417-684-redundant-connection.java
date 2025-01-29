class UnionFind {
	int[] parent;
	int[] rank;
	int n;
	
	public UnionFind(int n) {
		this.n = n;
		this.parent = new int[n + 1];
		this.rank = new int[n + 1];
		
		for(int i = 0; i <= n; i++) {
			parent[i] = i;
			rank[i] = i;
		}
	}

    public int findParent(int node) {
        if(parent[node] == node) {
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    public boolean unionNode(int node1, int node2) {
        int parent1 = findParent(node1);
        int parent2 = findParent(node2);

        if(parent1 == parent2) {
            return false;
        }

        if(rank[parent1] > rank[parent2]) {
            parent[parent2] = parent1;
        } else if(rank[parent1] < rank[parent2]) {
            parent[parent1] = parent2;
        } else {
            parent[parent2] = parent1;
            rank[parent1]++;
        }

        return true;
	}
}

class Solution {
	public int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;

		UnionFind unionFind = new UnionFind(n);
		
		int[] res = null;

		int u,v;
		for(int[] edge : edges) {
            u = edge[0]; v = edge[1];
			if(!unionFind.unionNode(u, v)) {
				res = new int[]{u, v};
			}
		}

		return res;
	}
}