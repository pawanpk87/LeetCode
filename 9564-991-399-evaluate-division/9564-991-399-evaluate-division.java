class Solution {
	private double dfs(String srcNode, String targetNode, Map<String, List<Pair<String, Double>>> adjList, Set<String> visited) {
		if(visited.contains(srcNode)) {
			return -1;
		}

		if(srcNode.equals(targetNode)) {
            return 1.0;
        }

        visited.add(srcNode);
        double res = -1; 

        for(Pair<String, Double> adjNode : adjList.get(srcNode)) {
            if(!visited.contains(adjNode)) {
                double tempRes = adjNode.getValue() * dfs(adjNode.getKey(), targetNode, adjList, visited);

                if(tempRes > 0) {
                    res = tempRes;
                    break;
                }
            }
        }

        return res;
	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		int n = equations.size();
		int qn = queries.size();
		
		Map<String, List<Pair<String, Double>>> adjList = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			String nodeA = equations.get(i).get(0);
			String nodeB = equations.get(i).get(1);
			double value = values[i];
			
			adjList.putIfAbsent(nodeA, new ArrayList<>());
			adjList.putIfAbsent(nodeB, new ArrayList<>());
			
			adjList.get(nodeA).add(new Pair(nodeB, value));
			adjList.get(nodeB).add(new Pair(nodeA, 1/value));
		}
		
		double[] res = new double[qn];

		for(int i = 0; i < qn; i++) {
			String nodeA = queries.get(i).get(0);
			String nodeB = queries.get(i).get(1);
			
			if(!adjList.containsKey(nodeA) || !adjList.containsKey(nodeB)) {
				res[i] = -1;
                continue;
			}
			
			Set<String> visited = new HashSet<>();
			res[i] = dfs(nodeA, nodeB, adjList, visited );
		}

		return res;
	}
}