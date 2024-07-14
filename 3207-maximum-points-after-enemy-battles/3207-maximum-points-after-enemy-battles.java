class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);
        
        int n = enemyEnergies.length;
        
        int i = 0, j = n -1;
        long currPoint = 0;
        
        while(i <= j){
            if(currentEnergy >= enemyEnergies[i]){
                int c = currentEnergy/enemyEnergies[i];
                currPoint += c;
                currentEnergy = currentEnergy - (c * enemyEnergies[i]);
            } else if(currPoint > 0) {
                currentEnergy += enemyEnergies[j];
                j--;
            } else {
                break;
            }
        }
        
        return currPoint;
    }
}