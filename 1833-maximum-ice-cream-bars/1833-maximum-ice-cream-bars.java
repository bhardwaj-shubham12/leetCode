class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int res = 0;
        int index = 0;

        while((index < costs.length) && (coins >= costs[index])){
            res++;
            coins -= costs[index++];
        }

        return res;
    }
}