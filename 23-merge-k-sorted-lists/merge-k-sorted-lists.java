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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)return null;
        return mergeK(lists, 0, lists.length - 1);
    }
    private ListNode mergeK(ListNode lists[], int i , int j){
        if(i == j)return lists[i];
        int m = (i + j) /2;
        ListNode l1 = mergeK(lists, i, m);
        ListNode l2 = mergeK(lists, m + 1, j);
        return merge(l1, l2);

    }
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null)return l2;
        if(l2 == null)return l1;
        ListNode head;
        ListNode tmp;
        if(l1.val <= l2.val){
            head = l1;
            tmp = head.next;
            head.next = merge(tmp, l2);
        }
        else{
            head = l2;
            tmp = head.next;
            head.next = merge(tmp, l1);
        }
        return head;

    }
}