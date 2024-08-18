//{ Driver Code Starts
import java.util.Scanner;
import java.math.*;

// Node Class
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

// Linked List Class
class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    // creates a new node with given value and appends it at the end of the linked list
    void insert(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }
}


public class Main {
    static void printList(Node n) 
    {
        while (n != null) {
            System.out.print(n.data);
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            LinkedList LL1 = new LinkedList();
            String l1 = sc.next();
            for (int j = 0; j < n; ++j) {
                int x = Character.getNumericValue(l1.charAt(j));
                LL1.insert(x);
            }

            int m = sc.nextInt();
            LinkedList LL2 = new LinkedList();
            String l2 = sc.next();
            for (int j = 0; j < m; ++j) {
                int x = Character.getNumericValue(l2.charAt(j));
                LL2.insert(x);
            }

            Solution ob = new Solution();
            Node res = ob.subLinkedList(LL1.head, LL2.head);
            printList(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    // Helper function to reverse a linked list
    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Helper function to remove leading zeros
    private Node removeLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head == null ? new Node(0) : head;
    }

    // Helper function to compare two lists
    private boolean isFirstListLarger(Node l1, Node l2) {
        l1 = removeLeadingZeros(l1);
        l2 = removeLeadingZeros(l2);
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        
        if (len1 != len2) return len1 > len2;
        
        while (l1 != null && l2 != null) {
            if (l1.data != l2.data) {
                return l1.data > l2.data;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return false; // Lists are equal
    }

    // Helper function to get length of list
    private int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public Node subLinkedList(Node l1, Node l2) {
        // Remove leading zeros
        l1 = removeLeadingZeros(l1);
        l2 = removeLeadingZeros(l2);

        // Determine which number is larger
        boolean isL1Larger = isFirstListLarger(l1, l2);
        Node larger = isL1Larger ? l1 : l2;
        Node smaller = isL1Larger ? l2 : l1;

        // Reverse both lists
        larger = reverse(larger);
        smaller = reverse(smaller);

        Node dummyHead = new Node(0);
        Node current = dummyHead;
        int borrow = 0;

        // Perform subtraction
        while (larger != null) {
            int x = larger.data;
            int y = (smaller != null) ? smaller.data : 0;

            int diff = x - y - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            current.next = new Node(diff);
            current = current.next;

            larger = larger.next;
            if (smaller != null) smaller = smaller.next;
        }

        // Reverse the result and remove leading zeros
        Node result = reverse(dummyHead.next);
        result = removeLeadingZeros(result);

        return result;
    }
}
        
