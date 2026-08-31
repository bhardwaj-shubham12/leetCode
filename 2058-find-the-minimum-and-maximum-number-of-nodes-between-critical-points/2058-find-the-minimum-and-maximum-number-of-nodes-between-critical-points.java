/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int prevIndex = -1;
        int minDistance = -1;
        int maxDistance = -1;
        ListNode prevNode = null;
        ListNode nextNode = head.next;
        int curIndex = 0;
        int firstIndex = -1;

        ListNode temp = head;
        while(temp != null){
            if((prevNode != null) && (nextNode != null)){
                if(((temp.val > prevNode.val) && (temp.val > nextNode.val))
                || ((temp.val < prevNode.val) && (temp.val < nextNode.val))){
                    if(prevIndex != -1){
                        maxDistance = curIndex - firstIndex;
                        minDistance = (minDistance != -1) ? Math.min(minDistance, curIndex - prevIndex) : (curIndex - prevIndex);
                        
                    }
                    else{
                        firstIndex = curIndex;
                    }
                    prevIndex = curIndex;
                }
            }
            curIndex++;
            prevNode = temp;
            temp = nextNode;
            if(nextNode != null)
                nextNode = nextNode.next;
        }

        int[] ans = new int[2];
        ans[0] = minDistance;
        ans[1] = maxDistance;
        return ans;
    }
}