// https://leetcode.com/problems/minimum-number-of-valid-strings-to-form-target-i/discuss/5788379/Trie-DP-oror-Simple-Approach

class TrieNode {
    boolean isEnd;
    TrieNode[] children;
    
    TrieNode() {
        this.isEnd = false;
        this.children = new TrieNode[26];
        for(int i = 0; i < 26; i++) {
            this.children[i] = null;
        }
    }
}

class Trie {
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String str) {
        int n = str.length();
        
        TrieNode currNode = root;
        
        for(int i = 0; i < n; i++) {
            int child = str.charAt(i) - 'a';
            if(currNode.children[child] == null) {
                currNode.children[child] = new TrieNode();
            }
            currNode = currNode.children[child];
            currNode.isEnd = true; 
        }
    }
    
    public List<Integer> getLongestPrefixLen(String str, int start) {
        int n = str.length();
        List<Integer> validLengths = new ArrayList<>();
        TrieNode currNode = root;
        for(int i = start; i < n; i++) {
            int child = str.charAt(i) - 'a';
            if(currNode.children[child] == null) {
                break;
            }
            currNode = currNode.children[child];
            if(currNode.isEnd) {
                validLengths.add((i - start + 1));
            }
        }
        return validLengths;
    }
}

class Solution {
    public int minValidStrings(String[] words, String target) {
        int n = target.length();
        
        Trie trie = new Trie();
        
        for(String word : words) {
            trie.insert(word);
        }
        
        int[] dp = new int[n + 1]; 
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // dp[i] = minimum number of valid string needed to make make target [0...i]
        
        dp[0] = 0;
        
        for(int i = 0; i < n; i++) {
            if(dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            
            List<Integer> validLengths = trie.getLongestPrefixLen(target, i);
            
            for(int len : validLengths) {
                dp[i + len] = Math.min(dp[i + len], dp[i] + 1);
                /*
                
                this means that string from i ... i + len is found as prefix in words
                so we only need dp[i] + 1
                i.e 
                prefix from 0...i then i ... i + len
                
                */
            }
        }
        
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}