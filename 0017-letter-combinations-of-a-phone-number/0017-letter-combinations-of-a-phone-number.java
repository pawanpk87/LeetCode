class Solution {
    private final Map<Character, List<Character>> mp;
    
    public Solution() {
        mp = new HashMap<>();
        mp.put('2', Arrays.asList('a', 'b', 'c'));
        mp.put('3', Arrays.asList('d', 'e', 'f'));
        mp.put('4', Arrays.asList('g', 'h', 'i'));
        mp.put('5', Arrays.asList('j', 'k', 'l'));
        mp.put('6', Arrays.asList('m', 'n', 'o'));
        mp.put('7', Arrays.asList('p', 'q', 'r', 's'));
        mp.put('8', Arrays.asList('t', 'u', 'v'));
        mp.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }
    
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        
        List<String> res = new ArrayList<>();
        
        if(n == 0) {
            return res;
        }
        
        Queue<String> queue = new LinkedList<>();
        
        for(Character ch : mp.get(digits.charAt(0))) {
            queue.add("" + ch);
        }
        
        int index = 1;
        
        while(index < n) {
            int size = queue.size();
            
            while(size-->0) {
                String currStr = queue.poll();
                for(char ch : mp.get(digits.charAt(index))) {
                    queue.add(currStr + ch);
                }
            }
            
            index++;
        }
        
        
        while(!queue.isEmpty()) {
            res.add(queue.poll());
        }
        
        return res;
    }
}