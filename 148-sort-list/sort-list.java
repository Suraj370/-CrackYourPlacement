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
            if (head == null || head.next == null) {
            return head;
        }
      
        // Find the midpoint of the list using the slow and fast pointer approach.
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next; // moves one step at a time
            fast = fast.next.next; // moves two steps at a time
        }
      
        // Split the list into two halves.
        ListNode mid = slow.next;
        slow.next = null;
      
        // Recursively sort each half.
        ListNode leftHalf = sortList(head);
        ListNode rightHalf = sortList(mid);
      
        // Merge the two halves and return the merged sorted list.
        return merge(leftHalf, rightHalf);
    }

     
    private ListNode merge(ListNode left, ListNode right) {
        // Create a dummy node to serve as the starting point for the merged list.
        ListNode dummyHead = new ListNode();
      
        // Use a pointer to build the new sorted linked list.
        ListNode current = dummyHead;
        while (left != null && right != null) {
            // Choose the node with the smaller value from either left or right,
            // and append it to the current node of the merged list.
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
      
        // If any nodes remain in either list, append them to the end of the merged list.
        current.next = (left == null) ? right : left;

        // Return the head of the merged sorted list, which is the next node of the dummy node.
        return dummyHead.next;
    }
}