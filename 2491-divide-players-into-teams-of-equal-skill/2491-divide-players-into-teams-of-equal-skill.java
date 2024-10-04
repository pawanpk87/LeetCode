class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        
        Map<Integer, Integer> mp = new HashMap<>();
        
        int total = 0;
        
        for(int s : skill) {
            total += s;
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }
        
        if(total%(n/2) != 0) {
            return -1;
        }
        
        int requiredSkillOfTeam = total/(n/2);
        long totalChemistry = 0;
        
        for(int s : mp.keySet()) {
            int freq = mp.get(s);
            int requiredParterSkill = requiredSkillOfTeam - s;
            
            if(!mp.containsKey(requiredParterSkill) || 
               freq != mp.get(requiredParterSkill)) {
                return -1;
            }
            
            totalChemistry += (long)s * (long)requiredParterSkill * freq;
        }
        
        return totalChemistry / 2;
    }
}