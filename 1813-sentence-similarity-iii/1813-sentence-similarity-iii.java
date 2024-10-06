class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length() <= sentence2.length()) {
            String[] s1 = sentence1.split(" ");
            String[] s2 = sentence2.split(" ");
            
            int n = s1.length;
            int m = s2.length;
            
            int pI = 0;
            
            while(pI < n) {
                if(!s1[pI].equals(s2[pI])) break;
                else {
                    pI++;
                }
            }
            
            int sI = n-1, j = m-1;
            
            while(sI >= 0) {
                if(!s1[sI].equals(s2[j])) break;
                else {
                    sI--;
                    j--;
                }
            }
            
            return pI > sI;
        } else {
            return areSentencesSimilar(sentence2, sentence1);
        }
    }
}