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
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0); 
        ListNode greaterHead = new ListNode(0); 
        ListNode lessTail = lessHead;
        ListNode greaterTail = greaterHead; 

        while (head != null) {
            if (head.val < x) {
                lessTail.next = head;
                lessTail = head;
            } else {
                greaterTail.next = head;
                greaterTail = head;
            }
            head = head.next; 
        }

        lessTail.next = greaterHead.next;
        greaterTail.next = null; 

        return lessHead.next;
    }
}