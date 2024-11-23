class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        
        char[][] rotatedBox = new char[m][n];
        
        for(int j = 0; j < m; j++) {
            for(int i = 0; i < n; i++) {
                rotatedBox[j][i] = box[i][j];
            }
            reverse(rotatedBox[j]);
        }
        
        for(int j = 0; j < n; j++) {
            arrangeStones(rotatedBox, j);
        }
        
        return rotatedBox;
    }
    
    private void arrangeStones(char[][] rotatedBox, int col) {
        int n = rotatedBox.length;
        
        int currRow = n - 1;
        int prevRow = n - 1;
        
        while(currRow >= 0) {
            if(rotatedBox[currRow][col] == '#') {
                rotatedBox[currRow][col] = '.';
                rotatedBox[prevRow][col] = '#';
                currRow--;
                prevRow--;
            } else if(rotatedBox[currRow][col] == '.') {
                currRow--;
            } else {
                prevRow = currRow - 1;
                currRow--;
            }
        }
    }
    
    private void reverse(char[] arr) {
        int i = 0, j = arr.length - 1;
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}














