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
    public ListNode reverseList(ListNode head) {
      if  (head == null|| head.next == null)return head;
        ListNode tmp = head.next;
       head.next = null;
        ListNode h1 = reverseList(tmp);
        tmp.next = head;
        return h1;
        
    }
}