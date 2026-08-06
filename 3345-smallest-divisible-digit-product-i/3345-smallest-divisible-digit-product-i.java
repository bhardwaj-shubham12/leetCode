class Solution {
    int prod(int n){
        int rem;
        int prod = 1;
        while(n > 0){
            rem = n % 10;
            prod = prod * rem;
            n /= 10;
        }
        return prod;
    }
    public int smallestNumber(int n, int t) {
        while(true){
            if((prod(n) % t) == 0) return n;
            n++;
        }
    }
}