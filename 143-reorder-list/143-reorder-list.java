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
    public void reorderList(ListNode head) {
        ListNode iter = head;
        ArrayList<ListNode> arr = new ArrayList<>();
        // put everything into an array for easy access to the index and the linkedlist size
        while(iter != null){
            arr.add(iter);
            iter = iter.next;
        }
        
        int start = 0;
        int end = arr.size() - 1;
        
        for(int i = 0 ; i < arr.size(); i++, head = head.next){
            // re order the array in alternating way
            if(i % 2 == 0){
                head.next = arr.get(start);
                start++;
            } else {
                head.next = arr.get(end);
                end--;
            }
        }
        head.next = null;
    }
}