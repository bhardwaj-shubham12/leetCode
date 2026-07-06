class Solution {
    private void merge(int[] nums, int l, int m, int r){
        int[] nums1 = new int[m - l + 1];
        int[] nums2 = new int[r - m];

        int index = 0;
        for(int i=l;i<=m;i++){
            nums1[index++] = nums[i];
        }

        index = 0;
        for(int i=m+1;i<=r;i++){
            nums2[index++] = nums[i];
        }

        index = l;
        int index1 = 0;
        int index2 = 0;
        while((index1 < nums1.length) && (index2 < nums2.length)){
            if(nums1[index1] <= nums2[index2]){
                nums[index++] = nums1[index1++];
            }
            else{
                nums[index++] = nums2[index2++];
            }
        }
        while(index1 < nums1.length){
            nums[index++] = nums1[index1++];
        }
        while(index2 < nums2.length){
            nums[index++] = nums2[index2++];
        }

    }
    private void mergeSort(int[] nums, int l, int r){
        if(l < r){
            int mid = l + (r-l)/2;
            mergeSort(nums,l,mid);
            mergeSort(nums,mid+1,r);
            merge(nums,l,mid,r);
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length - 1);
        return nums;
    }
}