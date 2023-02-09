class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String>[] group = new HashSet[26];
        
        for(int i=0; i<26; i++)
        {
            group[i] = new HashSet<>();
        }
        
        for(String idea : ideas)
        {
            group[idea.charAt(0) - 'a'].add(idea.substring(1));
        }
        
        long totalCount = 0;
        
        for(int i=0; i<25; i++)
        {
            for(int j=i+1; j<26; j++)
            {
                long mutual = 0;
                
                for(String idea : group[i])
                {
                    if(group[j].contains(idea))
                    {
                        mutual++;
                    }
                }
                
                totalCount += 2*(group[i].size() - mutual)*(group[j].size() - mutual);
            }
        }
        
        return totalCount;
    }
}