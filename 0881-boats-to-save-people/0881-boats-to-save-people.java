class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int boats = 0;
        int left = 0, right = n - 1;
        while(left < right){
            if((people[left] + people[right]) > limit){
                right--;
            } else{
                left++; 
                right--;
            }
            boats++;
        }
        if(left == right) boats++;
        return boats;
    }
}