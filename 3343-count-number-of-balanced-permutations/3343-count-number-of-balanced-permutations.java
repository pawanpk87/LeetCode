class BinomialCoefficientModularInverse {
    long MOD = 1000000007;
    
    int MAXN = 1000000;
    
    long[] factorial;
    long[] inverseFactorial;
    
    public BinomialCoefficientModularInverse() {
        factorial = new long[MAXN + 1];
        inverseFactorial = new long[MAXN + 1];
        
        init();
    }
    
    public BinomialCoefficientModularInverse(int maxn, long mod) {
        this.MOD = mod;
        this.MAXN = maxn;
        
        factorial = new long[MAXN + 1];
        inverseFactorial = new long[MAXN + 1];
        
        init();
    }
    
    private void init() {
        factorial[0] = 1;
        for(int i = 1; i <= MAXN; i++) {
            factorial[i] = multiMod(factorial[i - 1], i);
        }
        
        inverseFactorial[MAXN] = binaryExponentiation(factorial[MAXN], MOD - 2);
        for(int i = MAXN; i >= 1; i--) {
            inverseFactorial[i - 1] = multiMod(inverseFactorial[i], i);
        }
    }

    private long binaryExponentiation(long n, long k) {
        long pow = 1;
        while (k > 0) {
            if((k & 1) != 0) {
                pow = multiMod(pow, n);
            }
            n = multiMod(n, n);
            k = k >> 1;
        }
        return pow;
    }
    
    private long multiMod(long a, long b) {
        long na = a % MOD;
        long nb = b % MOD;
        return (na * nb) % MOD;
    }
    
    public long getFactorial(int num) {
        return factorial[num];
    }
    
    public long getInverseFactorial(int num) {
        return inverseFactorial[num];
    }
}

class Solution {
    public int countBalancedPermutations(String num) {
        int n = num.length();
        
        int[] freq = new int[10];
        
        int sum = 0;
        for(char ch : num.toCharArray()) {
            int d = ch - '0';
            freq[d]++;
            sum += d;
        }
        
        if(sum % 2 != 0) {
            return 0;
        }
        
        // =================== Binomial Coefficient Modular Inverse Start ============== 
        
        bcmi = new BinomialCoefficientModularInverse(n, MOD);
        
        int digits = 9;
        int indicies = n;
        int cumulativeSum = sum;
        
        dp = new long[10][n / 2 + 1][sum / 2 + 1];
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= n / 2; j++) {
                for (int k = 0; k <= sum / 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return (int) choose(0, 0, 0, sum, n, freq);
    }
    
    int MAXN = 1000000;
    int MOD = 1000000007;
    
    BinomialCoefficientModularInverse bcmi;
    
    long[][][] dp;

    private long choose(int currentDigit, 
                        int choosenIndicies, 
                        int cumulativeSum, 
                        int totalSum, 
                        int n, 
                        int[] freq) {
        
        if (choosenIndicies > n / 2 || cumulativeSum > totalSum / 2) {
            return 0;
        }
        
        // When id == 10, this means we've considered all digits from 0 to 9
        if(currentDigit == 10) {
            if((cumulativeSum * 2) == totalSum && choosenIndicies == n/2) {
                long numberOfWaysToChooseEvenIndicies = bcmi.getFactorial(n / 2);
                long numberOfWaysToChooseOddIndicies = bcmi.getFactorial((n + 1) / 2);
                return multiMod(numberOfWaysToChooseEvenIndicies, numberOfWaysToChooseOddIndicies);
            } else {
                return 0;
            }
        }
        
        if(dp[currentDigit][choosenIndicies][cumulativeSum] != -1) {
            return dp[currentDigit][choosenIndicies][cumulativeSum];
        }
        
        long ways = 0;
        
        for(int i = 0; i <= Math.min(freq[currentDigit], n/2 - choosenIndicies); i++) {
            /*
                number of ways to choose i occurence of the digits in the half of the indicies
                
                ( n )       n!
                (   )   = ------
                ( k )      k! * (n - k) !
                
                
                here 
                    n is freq[i]
                    k = i
            
            
                but we can't do (n/k) mod m XXXXXXXXXX
                
                            so that's why we use 
                                    fermat's little theorem

                                    a^m-1 = 1  mod m

                                    (a^m-1)/a = 1/a   mod m

                                    a^m-2 = a^-1


                        so whenever we want something like

                        (a/b) mod ?

                        (a/b) mod = ((a % mod) * (b^-1 % mod)) % mod
                
            */
            long tempN = choose(currentDigit + 1, choosenIndicies + i, cumulativeSum + (i * currentDigit), totalSum, n, freq);
            
            long tempK = bcmi.getInverseFactorial(i);
                
            long tempNMinusK = bcmi.getInverseFactorial(freq[currentDigit] - i);
            
            ways = (ways + multiMod(tempN, multiMod(tempK, tempNMinusK))) % MOD;
        }
        
        return dp[currentDigit][choosenIndicies][cumulativeSum] = ways;
    }
    
    private long multiMod(long a, long b) {
        long na = a % MOD;
        long nb = b % MOD;
        return (na * nb) % MOD;
    }
}