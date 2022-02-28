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
        if(head == null || head.next == null){
            return null;
        }
//         int count = 0;
//         ListNode itr = head;
//         while(itr != null){
//             count++;
//             itr = itr.next;
//         }
//         itr = head;
//         int mid = (int) Math.floor(count/2);
        
//         while(mid > 1){
//             itr = itr.next;
//             mid--;
//         }
        
//         itr.next = itr.next.next;
//         return head;
        
        //1 pass floyd and tortoise
        ListNode slow = head;
        ListNode fast = head.next.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
}