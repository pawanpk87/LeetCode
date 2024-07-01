class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        for(int i = 2; i < n; i++){
            if(isOdd(arr[i-2]) && isOdd(arr[i-1]) && isOdd(arr[i])){
                return true;
            }
        }
        return false;
    }
    
    private boolean isOdd(int num){
        return num%2 != 0;
    }
}