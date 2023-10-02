class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int alice = 0, bob = 0;
        for(int i = 1; i < n-1; i++){
            char prev = colors.charAt(i-1), 
                 curr = colors.charAt(i), 
                 next = colors.charAt(i+1);
            if(prev == curr && curr == next){
                if(curr == 'A') alice++;
                else bob++;
            }
        }
        return !(alice <= bob);
    }
}