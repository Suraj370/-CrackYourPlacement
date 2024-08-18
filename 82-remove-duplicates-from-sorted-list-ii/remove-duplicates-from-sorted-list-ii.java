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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(0, head);
      
        ListNode precedingNode = dummyNode;
      
        ListNode currentNode = head;
      
        while (currentNode != null) {
            while (currentNode.next != null && currentNode.next.val == currentNode.val) {
                currentNode = currentNode.next;
            }
          

            if (precedingNode.next == currentNode) {
                precedingNode = currentNode;
            } else {
          
                precedingNode.next = currentNode.next;
            }
            currentNode = currentNode.next;
        }
      
        return dummyNode.next;
    }
}