class Solution {
    
    public int countPrimeSetBits(int left, int right) {
        boolean[] isPrime = new boolean[33];
        Arrays.fill(isPrime, true);
    
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= 32; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 32; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int res = 0;
        for(int i=left;i<=right;i++){
            if(isPrime[Integer.bitCount(i)]){
                res++;
            }
        }
        return res;
    }
}