class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int count = 0;
        for(int start = 0; start < n - 1; start++){
            int a = 0;
            for(int mid = start + 1; mid < n; mid++){
                a ^= arr[mid - 1];
                int b = 0;
                for(int end = mid; end < n; end++){
                    b ^= arr[end];
                    if(a == b){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}