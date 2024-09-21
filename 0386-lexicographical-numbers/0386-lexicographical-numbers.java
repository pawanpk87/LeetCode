class Solution {
    
    private void generate(int currNum, int limit, List<Integer> res) {
        if(currNum > limit) {
            return;
        }
        
        res.add(currNum);
        
        for(int num = 0; num < 10; num++) {
            int nextNum = currNum * 10 + num;
            if(nextNum <= limit) {
                generate(nextNum, limit, res);
            } else {
                break;
            }
        }
    }
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int num = 1; num < 10; num++) {
            generate(num, n, res);
        }
        return res;
    }
}