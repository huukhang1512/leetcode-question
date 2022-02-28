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
    public ListNode deleteMiddle(ListNode head) {
        int count = 0;
        ListNode itr = head;
        while(itr != null){
            count++;
            itr = itr.next;
        }
        if(count == 1){
            return null;
        }
        itr = head;
        int mid = (int) Math.floor(count/2);
        
        
        while(mid >= 2){
            itr = itr.next;
            mid--;
        }
        
        itr.next = itr.next.next;
        return head;
    }
}