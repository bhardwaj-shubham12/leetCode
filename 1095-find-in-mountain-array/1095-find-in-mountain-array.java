/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    private int findBin(int target, int left, int right, MountainArray mountainArr, boolean dir){
        int mid;
        while(left <= right){
            mid = left + (right - left)/2;
            int midEle = mountainArr.get(mid);
            if(midEle == target){
                return mid;
            }
            else if(midEle > target){
                if(dir)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else{
                if(dir)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
       //find mountain index
       // check if target can belong to left
       // check if target can belong to right
       //if not either return -1

        int mountainLen = mountainArr.length();
        int l = 0;
        int r =  mountainLen - 1;
        int mid;
        boolean leftCheck = false, rightCheck = false;
        int peakIndex = -1;
        int midEle = -1;
        while(l <= r){
            mid = l + (r - l) / 2;
            midEle = mountainArr.get(mid);
            if((mid > 0) && (mid < mountainLen - 1)){
                leftCheck = (midEle > mountainArr.get(mid - 1));
                rightCheck = (midEle > mountainArr.get(mid + 1));
                if(leftCheck && rightCheck){
                    peakIndex = mid;
                    break;
                }
                else if(leftCheck){
                    l = mid + 1;
                }
                else{
                    r = mid - 1;
                }
            }
            else if(mid == 0){
                //this should never happen in mountain array
                int secondMid = mountainArr.get(mid + 1);
                if((secondMid > midEle) && (secondMid > mountainArr.get(mid + 2))){
                    peakIndex = mid + 1;
                    midEle = secondMid;
                    break;

                }
            }
            else{
                //System.out.println("oops");
                return -1;
                
            }
        }

        //System.out.println(peakIndex +": "+midEle);
        if(target == midEle){
            return peakIndex;
        }
        if(target > midEle) return -1;

        int leftMost = mountainArr.get(0);
        int rightMost = mountainArr.get(mountainLen - 1);
        
        if((target < leftMost) && (target < rightMost)){
            return -1;
            //not present in arr
        }
        int retVal = -1;
        retVal = findBin(target, 0, peakIndex - 1, mountainArr, true);
        if(retVal == -1){
            retVal = findBin(target, peakIndex + 1, mountainLen - 1, mountainArr, false);
        }
        
        return retVal;
        
    }
}