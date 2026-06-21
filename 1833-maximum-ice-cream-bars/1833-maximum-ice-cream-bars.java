class Solution {
    private int[] countingSort(int[] costs){
        int[] ans = new int[costs.length];
        
        int maxVal = costs[0];
        for(int i=1;i<costs.length;i++){
            maxVal = (costs[i] > maxVal) ? costs[i]: maxVal;
        }

        int[] counter = new int[maxVal + 1];
        for(int i=0;i<=maxVal;i++){
            counter[i] = 0;
        }

        for(int i=0;i<costs.length;i++){
            counter[costs[i]]++;
        }

        int index = 0;
        for(int i=1;i<=maxVal;i++){
            for(int j=0;j<counter[i];j++){
                ans[index++] = i;
            }
        }

        return ans;

    }
    public int maxIceCream(int[] costs, int coins) {
        int[] sortedCost = countingSort(costs);
        
        int index = 0;
        int res = 0;

        while((index < sortedCost.length) && (sortedCost[index] <= coins)){
            coins -= sortedCost[index++];
            res++;
        }

        return res;
    }
}