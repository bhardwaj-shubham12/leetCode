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
    public int pairSum(ListNode head) {
        List<Integer> listEle = new ArrayList<>();

        ListNode temp = head;
        while(temp != null){
            listEle.add(temp.val);
            temp = temp.next;
        }

        int listSize = listEle.size();
        int maxSum = 0;
        int curSum = 0;

        int index = 0;
        while(index < (listSize / 2)){
            curSum = listEle.get(index) + listEle.get(listSize - index - 1);
            maxSum = (curSum > maxSum) ? curSum : maxSum;
            index++;
        }

        return maxSum;
    }
}