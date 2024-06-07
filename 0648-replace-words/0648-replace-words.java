class TrieNode{
    public TrieNode[] children;
    public boolean isEndWord;
    
    public TrieNode(){
        children = new TrieNode[26];
        for(int i = 0; i < 26; i++){
            children[i] = null;
        }
        isEndWord = false;
    }
}

class Trie{
    public TrieNode root;
    
    public Trie(List<String> dictionary){
        root = new TrieNode();
        buildTree(dictionary);
    }
    
    public void buildTree(List<String> dictionary){
        for(String word : dictionary){
            insert(word);
        }
    }
    
    private void insert(String str){
        TrieNode currNode = root;
        for(char ch : str.toCharArray()){
            if(currNode.children[(ch - 'a')] == null){
                currNode.children[(ch - 'a')] = new TrieNode();
            }
            currNode = currNode.children[(ch - 'a')];
        }
        currNode.isEndWord = true;
    }
    
    public String findRoot(String derivative){
        TrieNode currNode = root;
        StringBuilder rootWord = new StringBuilder();
        for(char ch : derivative.toCharArray()){
            if(currNode.children[(ch - 'a')] == null){
                return null;
            }
            currNode = currNode.children[(ch - 'a')];
            rootWord.append(ch);
            if(currNode.isEndWord == true){
                return rootWord.toString();
            }
        }
        return null;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie(dictionary);
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(String word : words){
            String rootWord = trie.findRoot(word);
            if(rootWord == null){
                result.append(word + " ");
            } else{
                result.append(rootWord + " ");
            }
        }
        return result.substring(0, result.length()-1).toString();
    }
}