class Solution {
    private List<List<String>> partitions;
    
    private void solve(int currIndex, ArrayList<String> currPartition, String s, int n){
        if(currIndex == n){
            partitions.add(new ArrayList(currPartition));
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = currIndex; i < n; i++){
            sb.append(s.charAt(i));
            if(isPalindrome(sb.toString())){
                currPartition.add(sb.toString());
                
                solve(i+1, currPartition, s, n);
                
                currPartition.remove(currPartition.size() - 1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        int n = s.length();
        
        partitions = new ArrayList<>();
        
        solve(0, new ArrayList<String>(), s, n);
        
        return partitions;
    }
    
    public boolean isPalindrome(String str){
        int i = 0, j = str.length() - 1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++; j--;
        }
        return true;
    }
}