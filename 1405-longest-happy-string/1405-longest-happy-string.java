class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                return p2.count - p1.count;
            }    
        });
        
        if(a > 0) maxHeap.add(new Pair('a', a));
        
        if(b > 0) maxHeap.add(new Pair('b', b));
        
        if(c > 0) maxHeap.add(new Pair('c', c));
        
        StringBuilder ans = new StringBuilder();
        
        while(!maxHeap.isEmpty()) {
            Pair p = maxHeap.poll();
            char ch = p.ch;
            int count = p.count;
            
            if(ans.length() >= 2 &&
               ans.charAt(ans.length() - 1) == ch &&
               ans.charAt(ans.length() - 2) == ch) {
                if(maxHeap.isEmpty()) {
                    break;
                }
                
                Pair temp = maxHeap.poll();
                ans.append(temp.ch);
                if((temp.count-1) > 0) {
                    maxHeap.add(new Pair(temp.ch, temp.count - 1));
                }
            } else {
                count--;
                ans.append(ch);
            }
            
            if(count > 0) {
                maxHeap.add(new Pair(ch, count));
            }
        }
        
        return ans.toString();
    }
    
    static class Pair {
        char ch;
        int count;
        
        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}