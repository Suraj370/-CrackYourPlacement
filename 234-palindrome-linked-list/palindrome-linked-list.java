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
        public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode t = reverseList(mid);
        ListNode h =  head;
        while(h != null && t != null){
            if(h.val != t.val)
                return false;
            h = h.next;
            t = t.next;
        }
        return true;
    }
    
    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode tmp = head.next;
        head.next = null;
        ListNode head1 = reverseList(tmp);
        tmp.next = head;
        return head1;
    }
}