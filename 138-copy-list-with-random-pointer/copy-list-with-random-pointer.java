/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node cloneHead = null;
        Node tmp  = null;
        Node curr = head;
        while(curr != null){
            tmp = new Node(curr.val);
         
            if(curr == head ){
                cloneHead = tmp;
            }
            Node t = curr.next;
            curr.next = tmp;
            tmp.next = t;
            curr = t;
         }
        curr = head;
        while(curr != null){
            if(curr.random != null)
                curr.next.random = curr.random.next;
            else
                curr.next.random = null;
            curr = curr.next.next;
        }
        curr = cloneHead;
        Node curr1 = head;
        while(curr != null && curr.next != null){
            Node t = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            curr1.next = t;
            curr1 = curr1.next;
        }
        if(curr1 != null)
            curr1.next = null;
        return cloneHead;



    }
}