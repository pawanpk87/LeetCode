class Solution {
    private int[][] memo;
    
    private int solve(int currIndex, int remainingShelfWidth, int maxHeight, int[][] books, int shelfWidth) {
        int maxHeightUpdated = Math.max(maxHeight, books[currIndex][1]);
        
        if(currIndex == books.length - 1) {
            if(books[currIndex][0] <= remainingShelfWidth) {
                return maxHeightUpdated;
            } else {
                return maxHeight + books[currIndex][1];
            }
        }
        
        if(memo[currIndex][remainingShelfWidth] != -1) {
            return memo[currIndex][remainingShelfWidth];
        }
        
        int pos1 = maxHeight + solve(currIndex + 1, 
                                     shelfWidth - books[currIndex][0], 
                                     books[currIndex][1], 
                                     books,
                                     shelfWidth);
        if(books[currIndex][0] <= remainingShelfWidth) {
            int pos2 = solve(currIndex + 1, 
                             remainingShelfWidth - books[currIndex][0], 
                             maxHeightUpdated, 
                             books,
                             shelfWidth);
            
            return memo[currIndex][remainingShelfWidth] = Math.min(pos1, pos2);
        }
        
        return memo[currIndex][remainingShelfWidth] = pos1;
    }
    
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        
        memo = new int[n][shelfWidth+1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
            
        return solve(0, shelfWidth, 0, books, shelfWidth);
    }
}
/*

    books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelfWidth = 4
    
    -   -   -   -
    -   -   -
    -   -   -   -
    
    1,2 -> 2
    2,1,1 -> 3
    1,2 -> 2
    
  
    
    [[1,3],[2,4],[3,2]], shelfWidth = 6
    
    1,2,3, -> 4
    
    
    
  currTik = 0    shelfWidth = 4      [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]]
                                      /  \
                                     /    \
                          curTik 1 h = 1       currTik = 0          
                     /                 \
    currTik = 3 h = 2                 currTik = 1 
       /        \
            currTik = 2
            /           \
    currTik =     
                 
                 
    
    
*/