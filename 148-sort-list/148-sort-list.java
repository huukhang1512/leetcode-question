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
    public ListNode sortList(ListNode head) {
        // O(N) put everything into a heap
        // sort that list
        // create a new treeNode
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        ListNode itr = head;
        while(itr != null){
            heap.offer(itr.val);
            itr = itr.next;
        }
        
        ListNode res = new ListNode();
        ListNode clone = res;
        while(!heap.isEmpty()){
            clone.next = new ListNode(heap.poll());
            clone = clone.next;
        }
        return res.next;
    }
}