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
        // O(N) put everything into an arrrayList
        // sort that list
        // create a new treeNode
        
        ArrayList<Integer> list = new ArrayList<>();
        ListNode itr = head;
        while(itr != null){
            list.add(itr.val);
            itr = itr.next;
        }
        
        Collections.sort(list);
        ListNode res = new ListNode();
        ListNode clone = res;
        for(int i = 0; i < list.size(); i++){
            clone.next = new ListNode(list.get(i));
            clone = clone.next;
        }
        return res.next;
    }
}