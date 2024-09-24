class TrieNode {
    TrieNode[] children;
    
    public TrieNode() {
        this.children = new TrieNode[10];
        for(int i = 0; i < 10; i++) {
            this.children[i] = null;
        }
    }
}

class Trie {
    TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(int num) {
        TrieNode currNode = root;
        String strNum = String.valueOf(num);
        for(int i = 0; i < strNum.length(); i++) {
            int digit = strNum.charAt(i) - '0';
            if(currNode.children[digit] == null) {
                currNode.children[digit] = new TrieNode();
            }
            currNode = currNode.children[digit];
        }
    }
    
    public int maxPrefix(int num) {
        TrieNode currNode = root;
        String strNum = String.valueOf(num);
        int count = 0;
        for(int i = 0; i < strNum.length(); i++) {
            int digit = strNum.charAt(i) - '0';
            if(currNode.children[digit] == null) {
                break;
            }
            currNode = currNode.children[digit];
            count++;
        }
        return count;
    }
}

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        
        for(int num : arr1) {
            trie.insert(num);
        }
        
        int maxCommonPrefix = 0;
        
        for(int num : arr2) {
            maxCommonPrefix = Math.max(maxCommonPrefix, trie.maxPrefix(num));
        }
        
        return maxCommonPrefix;
    }
}