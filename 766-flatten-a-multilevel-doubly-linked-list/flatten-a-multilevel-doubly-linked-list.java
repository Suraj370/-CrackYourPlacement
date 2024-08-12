/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        return flatten(head, null);
    }
    
    private Node flatten(Node head, Node tail){
        if(head == null) return tail;
        if(head.child == null){
            Node next = flatten(head.next, tail);
            head.next = next;
            if(next != null)next.prev = head;
        }
        else{
            Node child = flatten(head.child,flatten(head.next,tail));
            head.next = child;
            if(child != null)child.prev = head;
            head.child = null;
        }
        return head;
        }
    
}