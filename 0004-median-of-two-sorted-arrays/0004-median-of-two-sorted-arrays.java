class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = n1;
        int mid1 = (left + right)/2;
        int total = n1 + n2;
        int mid2 = ((n1 + n2 + 1)/2) - mid1;
        int maxLeftA,maxLeftB, minRightA, minRightB;
        while(left <= right){
            mid1 = (left + right)/2;
            mid2 = ((n1 + n2 + 1)/2) - mid1;
            maxLeftA = (mid1 == 0) ? Integer.MIN_VALUE: nums1[mid1 - 1];
            maxLeftB = (mid2 == 0) ? Integer.MIN_VALUE: nums2[mid2 - 1];
            minRightA = (mid1 == n1) ? Integer.MAX_VALUE: nums1[mid1];
            minRightB = (mid2 == n2) ? Integer.MAX_VALUE: nums2[mid2];

            if((maxLeftA <= minRightB) && (maxLeftB <= minRightA)){
                if((total % 2) == 1){
                    return (double)Math.max(maxLeftA, maxLeftB);
                }
                else{
                    return ((double)Math.max(maxLeftA, maxLeftB) + (double)Math.min(minRightA, minRightB)) / 2.0;
                }
            }
            else if(maxLeftA > minRightB){
                right = mid1 - 1;
            }
            else{
                left = mid1 + 1;
            }
        }
        return 0.0;
    }
}