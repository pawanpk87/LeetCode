class Solution {
    public int findTheWinner(int n, int k) {
        int[] arr = new int[n];
        for(int i = 1; i <= n; i++){
            arr[i-1] = i;
        }
        int count = n;
        int currK = k;
        int i = 0;
        while(count > 1){
            if(arr[i] != -1){
                currK--;
                if(currK == 0){
                    arr[i] = -1;
                    currK = k;
                    count--;
                }
            }
            i++;
            i = i%n;
        }
        for(int j = 0; j < n; j++){
            if(arr[j] != -1){
                return arr[j];
            }
        }
        return -1;
    }
}