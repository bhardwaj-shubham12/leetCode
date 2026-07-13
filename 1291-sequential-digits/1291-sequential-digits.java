class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        // Take the first digit of the first number >= low
        // Take the first digit of the last number <= high

        int numDigitLow = (int)(Math.floor(Math.log10(low))) + 1;
        int numDigitHigh = (int)(Math.floor(Math.log10(high))) + 1;
        //System.out.println("numDigitLow: "+numDigitLow);
        //System.out.println("numDigitHigh: "+numDigitHigh);
        int cur10s;
        int curDigit = numDigitLow;
        int firstDigit =  -1;
        int numNumbers;
        

        while(curDigit <= numDigitHigh){
            numNumbers = 9 - curDigit + 1;
            int cur = 1;
            int temp = curDigit - 1;
            cur10s = (int)Math.pow(10, curDigit - 1);
            //System.out.println("cur10s: "+cur10s);
            //making first number starting with 1
            while(temp > 0){
                int rem = cur % 10;
                cur = (cur * 10) + (rem+1);
                temp--;
            }
            //System.out.println("First number: "+ cur);
            //iterating over all numbers
            while(numNumbers > 0){
                if(cur >= low){
                    if(cur > high) return ans;
                    //System.out.println("Adding:"+cur);
                    ans.add(cur);
                }
                int rem = cur % 10;
                cur = ((cur % cur10s)) * 10 + (rem + 1);
                numNumbers--;
            }
            curDigit++;
        }

        return ans;
    }
}