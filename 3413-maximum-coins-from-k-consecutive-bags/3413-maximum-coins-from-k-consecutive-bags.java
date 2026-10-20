import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public long maximumCoins(int[][] coins, int k) {
        Arrays.sort(coins, Comparator.comparingInt(a -> a[0]));

        int n = coins.length;
        long[] prefixSum = new long[n + 1];
        prefixSum[0] = 0;


        for (int i = 0; i < n; i++) {
            int start = coins[i][0];
            int end = coins[i][1];
            int value = coins[i][2];
            prefixSum[i + 1] = prefixSum[i] + (long) value * (end - start + 1);
        }

        long maxCoins = 0;


        for (int i = 0; i < n; i++) {
            int start = coins[i][0];
            int end = start + k - 1;
            maxCoins = Math.max(maxCoins, calculateRangeCoins(coins, prefixSum, start, end));
        }

        for (int i = 0; i < n; i++) {
            int end = coins[i][1];
            int start = end - k + 1;
            maxCoins = Math.max(maxCoins, calculateRangeCoins(coins, prefixSum, start, end));
        }

        return maxCoins;
    }

    private long calculateRangeCoins(int[][] coins, long[] prefixSum, int start, int end) {
        return getCoinsAt(coins, prefixSum, end) - getCoinsAt(coins, prefixSum, start - 1);
    }

    private long getCoinsAt(int[][] coins, long[] prefixSum, int index) {
        if (index < coins[0][0]) {
            return 0;
        }

        int left = 0;
        int right = coins.length - 1;
        int latest = coins.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (index >= coins[mid][0]) {
                latest = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (latest == coins.length) {
            return 0;
        }

        int coverageStart = coins[latest][0];
        int coverageEnd = Math.min(coins[latest][1], index);
        int value = coins[latest][2];

        return prefixSum[latest] + (long) value * (coverageEnd - coverageStart + 1);
    }
}