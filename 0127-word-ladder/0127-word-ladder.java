class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordListSt = new HashSet(wordList);
        
        int count = 1;
        
        Queue<String> bfs = new LinkedList<String>();
        Set<String> visited = new HashSet<>();
        
        bfs.offer(beginWord);
        visited.add(beginWord);
        
        while(!bfs.isEmpty()){
            int n = bfs.size();
            while(n-- > 0){
                StringBuilder currWord = new StringBuilder(bfs.poll());
                
                if(currWord.toString().equals(endWord)){
                    return count;
                }
                
                for(int i = 0; i < currWord.length(); i++){
                    char prevChar = currWord.charAt(i);
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if(ch == prevChar){
                            continue;
                        }
                        
                        currWord.setCharAt(i, ch);
                        
                        if(wordListSt.contains(currWord.toString()) && 
                           visited.contains(currWord.toString()) == false){
                            bfs.offer(currWord.toString());
                            visited.add(currWord.toString());
                        }
                    }
                    currWord.setCharAt(i, prevChar);
                }
            }
            count++;
        }
        
        return 0;
    }
}