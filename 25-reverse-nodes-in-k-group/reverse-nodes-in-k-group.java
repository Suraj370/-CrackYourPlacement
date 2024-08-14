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
    public ListNode reverseKGroup(ListNode head, int k) {
        int cnt = 0;
        ListNode curr = head;
        
        while(curr != null && cnt < k){
            cnt = cnt + 1;
            curr = curr.next;
        }
        if(cnt < k)
            return head;
        curr = head;
        ListNode prev = null;
        ListNode tmp = null;
        cnt = 0;
        while(cnt < k){
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            cnt = cnt + 1;
            
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}