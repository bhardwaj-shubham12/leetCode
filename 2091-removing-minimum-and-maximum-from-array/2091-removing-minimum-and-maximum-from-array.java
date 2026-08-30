class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
            if (nums[i] < nums[minIndex]) minIndex = i;
        }

        int first = Math.min(minIndex, maxIndex);
        int second = Math.max(minIndex, maxIndex);

        // 1. Both from the front
        int fromFront = second + 1;
        // 2. Both from the back
        int fromBack = n - first;
        // 3. One from front, one from back
        int fromBothEnds = (first + 1) + (n - second);

        return Math.min(fromFront, Math.min(fromBack, fromBothEnds));
    }
}