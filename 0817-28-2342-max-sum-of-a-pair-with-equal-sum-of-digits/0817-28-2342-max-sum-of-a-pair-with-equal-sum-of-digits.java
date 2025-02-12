class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        
        Map<Integer, PriorityQueue<Integer>> mp = new HashMap<>();

        for(int num : nums) {
            int digitSum = digitSum(num);

            mp.putIfAbsent(digitSum, new PriorityQueue<>());

            mp.get(digitSum).add(num);
            if(mp.get(digitSum).size() > 2) {
                mp.get(digitSum).poll();
            }
        }

        int maxSum = -1;

        for(PriorityQueue<Integer> q : mp.values()) {
            if(q.size() == 2) {
                maxSum = Math.max(maxSum, q.poll() + q.poll());
            }
        }

        return maxSum;
    }

    private int digitSum(int num) {
        int sum = 0;
        while(num > 0) {
            int d = num % 10;
            sum += d;
            num = num/10;
        }
        return sum;
    }
}