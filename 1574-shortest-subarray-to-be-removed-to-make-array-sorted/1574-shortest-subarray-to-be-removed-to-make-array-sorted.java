class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        
        int shortestSubarray = Integer.MAX_VALUE;
        
        int secondSubArrStartIndex = n-1;
        
        while(secondSubArrStartIndex > 0 && 
              arr[secondSubArrStartIndex] >= arr[secondSubArrStartIndex - 1]) {
            secondSubArrStartIndex--;
        }
        
        shortestSubarray = secondSubArrStartIndex;
        
        int firstSubArrayEndIndex = 0;
        
        while(firstSubArrayEndIndex < secondSubArrStartIndex &&
              (firstSubArrayEndIndex == 0 || (arr[firstSubArrayEndIndex - 1] <= arr[firstSubArrayEndIndex]))) {
            
            while(secondSubArrStartIndex < n && arr[firstSubArrayEndIndex] > arr[secondSubArrStartIndex]) {
                secondSubArrStartIndex++;
            }
            
            shortestSubarray = Math.min(shortestSubarray, secondSubArrStartIndex - firstSubArrayEndIndex - 1);
        
            firstSubArrayEndIndex++;
        }
        
        return shortestSubarray;
    }
}