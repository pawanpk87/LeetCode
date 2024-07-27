class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long totalCost = 0;
        
        long[][] minDist = new long[26][26];
        for(int i = 0; i < 26; i++) {
            Arrays.fill(minDist[i], Integer.MAX_VALUE);
        }
        
        int src, dest, ct;
        for(int i = 0; i <  original.length; i++) {
            src = original[i] - 'a';
            dest = changed[i] - 'a';
            ct = cost[i];
    
            minDist[src][dest] = Math.min(minDist[src][dest], (long) ct);
        }
        
        for(int itermediateNode = 0; itermediateNode < 26; itermediateNode++) {
            for(int sourceNode = 0; sourceNode < 26; sourceNode++) {
                for(int destNode = 0; destNode < 26; destNode++) {
                    if(minDist[sourceNode][itermediateNode] == Integer.MAX_VALUE || 
                       minDist[itermediateNode][destNode] == Integer.MAX_VALUE) {
                        continue;
                    }
                    
                    if(minDist[sourceNode][destNode] == Integer.MAX_VALUE) {
                        minDist[sourceNode][destNode] = minDist[sourceNode][itermediateNode] + minDist[itermediateNode][destNode];
                    } else {
                        minDist[sourceNode][destNode] = Math.min(minDist[sourceNode][destNode],
                                                                 minDist[sourceNode][itermediateNode] + minDist[itermediateNode][destNode]);
                    }
                }
            }
        }
        
        
        
        for(int i = 0; i < source.length(); i++) {
            src = source.charAt(i) - 'a';
            dest = target.charAt(i) - 'a';
            
            if(src == dest) {
                continue;
            }
            
            if(minDist[src][dest] >= Integer.MAX_VALUE) {
                return -1;
            }
            
            totalCost += minDist[src][dest];
        }
        
        return totalCost;
    }
}