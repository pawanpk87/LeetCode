class Solution {
    long higestScore = 0;
    Map<Long, Integer> freq;
    
    private long countNodes(int currNode, List<List<Integer>> adjList, int totalNodes) {
        long leftSubTreeNodeCounts = 0, rightSubTreeNodeCount = 0;
        
        if(adjList.get(currNode).size() > 0) {
            leftSubTreeNodeCounts = countNodes(adjList.get(currNode).get(0), adjList, totalNodes);
        }
        
        if(adjList.get(currNode).size() > 1) {
            rightSubTreeNodeCount = countNodes(adjList.get(currNode).get(1), adjList, totalNodes);
        }
        
        long currNodeScore = calculateScore(leftSubTreeNodeCounts, rightSubTreeNodeCount, totalNodes);
    
        freq.put(currNodeScore, freq.getOrDefault(currNodeScore, 0) + 1);
        
        higestScore = Math.max(higestScore, currNodeScore);
        
        return 1 + leftSubTreeNodeCounts + rightSubTreeNodeCount;
    }
    
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int i = 1; i < n; i++) {
            adjList.get(parents[i]).add(i);
        }
        
        freq = new HashMap<>();
        
        countNodes(0, adjList, n);
        
        return freq.get(higestScore);
    }
    
    private long calculateScore(long leftSubTreeNodeCounts, long rightSubTreeNodeCount, int treeNodeCount) {
        treeNodeCount--;
        long upperTreeNodeCount = treeNodeCount - leftSubTreeNodeCounts - rightSubTreeNodeCount;
        if(leftSubTreeNodeCounts == 0) leftSubTreeNodeCounts = 1;
        if(rightSubTreeNodeCount == 0) rightSubTreeNodeCount = 1;
        if(upperTreeNodeCount == 0) upperTreeNodeCount = 1;
        return leftSubTreeNodeCounts * rightSubTreeNodeCount * upperTreeNodeCount;
    }
}