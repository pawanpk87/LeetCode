class SegmentTree{
    private int[] tree;
    private int n;
    
    public SegmentTree(int n, int[] nums){
        this.n = n;
        tree = new int[(4 * n)];
        buildTree(1, 0, n-1, nums);
    }
    
    private void buildTree(int v, int tl, int tr, int[] nums){
        if(tl == tr){
            tree[v] = nums[tl];
        } else{
            int mid = (tl + tr)/2;
            buildTree(2*v, tl, mid, nums);
            buildTree(2*v+1, mid+1, tr, nums);
            tree[v] = tree[2*v] & tree[2*v + 1];
        }
    }
    
    public int bitwiseAnd(int ql, int qr){
        return bitwiseAnd(1, 0, n-1, ql, qr);
    }
    
    private int bitwiseAnd(int v, int tl, int tr, int ql, int qr){
        if(ql > tr || qr < tl){
            return Integer.MAX_VALUE;
        }
        if(tl >= ql && tr <= qr){
            return tree[v];
        }
        int mid = (tl + tr)/2;
        int leftAnd = bitwiseAnd(2*v, tl, mid, ql, qr);
        int rightAnd = bitwiseAnd(2*v + 1, mid+1, tr, ql, qr);
        return leftAnd & rightAnd;
    }
}

class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        SegmentTree st = new SegmentTree(n, nums);
        int minDiff = Integer.MAX_VALUE;
        for(int L = 0; L < n; L++){
            int low = L, high = n-1;
            while(low <= high){
                int R = (low + high)/2;
                int bitwiseAndVal = st.bitwiseAnd(L, R);
                minDiff = Math.min(minDiff, Math.abs(k - bitwiseAndVal));
                if(bitwiseAndVal < k){
                    high = R - 1;
                } else if(bitwiseAndVal > k){
                    low = R + 1;
                } else{
                    return minDiff;
                }
            }
        }
        return minDiff;
    }
}