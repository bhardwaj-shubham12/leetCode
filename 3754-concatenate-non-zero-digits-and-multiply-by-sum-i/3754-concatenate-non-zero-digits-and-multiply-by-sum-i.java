class Solution {
    public long sumAndMultiply(int n) {
        long temp = 0;
        int rem;
        while(n > 0){
            rem = n % 10;
            if(rem != 0){
                temp = temp * 10 + rem;
            }
            n/= 10;
        }

        long sum = 0;
        long res = 0;
        while(temp > 0){
            rem = (int)temp % 10;
            res = res*10 + rem;
            sum += rem;
            temp /= 10;
        }

        return sum * res;
    }
}