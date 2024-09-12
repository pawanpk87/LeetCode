class Solution {
    private Set<Character> consistentCharacters;
    
    public Solution() {
        consistentCharacters = new HashSet<>();
    }
    
    private boolean isConsistentString(String word) {
        int n = word.length();
        
        for(int i = 0; i < n; i++) {
            if(!consistentCharacters.contains(word.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }
    
    public int countConsistentStrings(String allowed, String[] words) {
        for(int i = 0; i < allowed.length(); i++) {
            consistentCharacters.add(allowed.charAt(i));
        }
        
        int count = 0;
        for(String word : words) {
            if(isConsistentString(word)) {
                count++;
            }
        }
        
        return count;
    }
}