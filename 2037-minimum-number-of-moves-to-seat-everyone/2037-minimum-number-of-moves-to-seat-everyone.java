class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int n = seats.length;
        
        Arrays.sort(seats);
        Arrays.sort(students);
        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            count += Math.abs(seats[i] - students[i]);
        }
        
        return count;
    }
}