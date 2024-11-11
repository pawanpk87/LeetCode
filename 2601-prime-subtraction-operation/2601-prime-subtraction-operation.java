class Solution {
    private List<Integer> primeNumbers;

    public Solution() {
        sieveAlgo();
    }

    public void sieveAlgo() {
        int n = 10000;

        boolean[] prime = new boolean[n + 1];

        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for(int i = 2; (i*i) <= n; i++) {
            if(prime[i]) {
                for(int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        primeNumbers = new ArrayList<>();

        for(int i = 2; i <= n; i++) {
            if(prime[i]) {
                primeNumbers.add(i);
            }
        }
    }

    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        
        for(int i = n-2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                continue;
            }
            
            boolean flag = false;
            
            for(int j = 0; 
                    j < primeNumbers.size() && primeNumbers.get(j) < nums[i]; 
                        j++) {
                
                if((nums[i] - primeNumbers.get(j)) < nums[i + 1]) {
                    nums[i] = nums[i] - primeNumbers.get(j);
                    flag = true;
                    break;
                }
            }
            
            if(flag == false) {
                return false;
            }
        }
        
        return true;
    }
}