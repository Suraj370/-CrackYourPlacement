/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Boolean> m = new HashMap<>();
        ListNode curr = head;
        while(curr != null){
            if(m.containsKey(curr))
                return true;
            m.put(curr, true);
            curr = curr.next;
        }
        return false;
    }
}