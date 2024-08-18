class Solution {
    long[][] memo;
    
    private long solve(int index, int drink, int[] energyDrinkA, int[] energyDrinkB) {
        if(index >= energyDrinkA.length) {
            return 0;
        }    
        
        if(memo[index][drink] != -1) {
            return memo[index][drink];
        }
        
        long maxEng = 0;
        
        if(drink == 0) {
            long opt1 = solve(index + 1, drink, energyDrinkA, energyDrinkB);
            long opt2 = solve(index + 2, 1, energyDrinkA, energyDrinkB);
            
            maxEng = energyDrinkA[index] + Math.max(opt1, opt2);
        } else {
            long opt1 = solve(index + 1, drink, energyDrinkA, energyDrinkB);
            long opt2 = solve(index + 2, 0, energyDrinkA, energyDrinkB);
            
            maxEng = energyDrinkB[index] + Math.max(opt1, opt2);
        }
        
        return memo[index][drink] = maxEng;
    }
    
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        
        memo = new long[n][2];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return Math.max(solve(0, 0, energyDrinkA, energyDrinkB),
                        solve(0, 1, energyDrinkA, energyDrinkB));
    }
}