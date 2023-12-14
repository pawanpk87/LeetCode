class Pair{
    public int zero;
    public int one;
    
    public Pair(){
        this.zero = 0;
        this.one = 0;
    }
    
    public Pair(int zero, int one){
        this.zero = zero;
        this.one = one;
    }
}

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Map<Integer, Pair> mp1 = new HashMap<Integer, Pair>();
        Map<Integer, Pair> mp2 = new HashMap<Integer, Pair>();
        
        for(int i = 0; i < n; i++){
            int zero = 0, one = 0;
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    zero++;
                }else{
                    one++;
                }
            }
            mp1.put(i, new Pair(zero, one));
        }
        
        for(int j = 0; j < m; j++){
            int zero = 0, one = 0;
            for(int i = 0; i < n; i++){
                if(grid[i][j] == 0){
                    zero++;
                }else{
                    one++;
                }
            }
            mp2.put(j, new Pair(zero, one));
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int zerosRowi = mp1.get(i).zero;
                int onesRowi = mp1.get(i).one;
                
                int zerosColj = mp2.get(j).zero;
                int onesColj = mp2.get(j).one;
                
                grid[i][j] = onesRowi + onesColj - zerosRowi - zerosColj;
            }
        }
        
        return grid;
    }
}