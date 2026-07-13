class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size();
        int n = nums2.size();
        if(m>n)
            return findMedianSortedArrays(nums2,nums1);
        
        int left = 0;
        int right = m;
        int mid1,mid2;
        int maxLeftA,minRightA,maxLeftB,minRightB;
        int total = n + m;

        while(left <= right)
        {
            mid1 = (left+right)/2;
            mid2 = (m+n+1)/2 - mid1;

            maxLeftA = (mid1 == 0) ? INT_MIN:nums1[mid1-1];
            minRightA = (mid1 == m)? INT_MAX:nums1[mid1];

            maxLeftB = (mid2 == 0) ? INT_MIN:nums2[mid2-1];
            minRightB = (mid2 == n) ? INT_MAX:nums2[mid2];

            if((maxLeftA <= minRightB) && (maxLeftB <= minRightA))
            {
                if(total%2)
                {
                    return (double)max(maxLeftA,maxLeftB);
                }
                else
                {
                    return ((double)max(maxLeftA,maxLeftB) + (double)min(minRightA,minRightB))/2.0;
                }
            }
            else if(maxLeftA > minRightB)
            {
                right = mid1 - 1;
            }
            else
            {
                left = mid1 + 1;
            }

        } 
        return 0.0;  
    }
};