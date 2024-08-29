//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution obj = new Solution();
            Node res = obj.Bst(arr, n);
            printPostorder(res);
            System.out.println();
        }
    }

    
// } Driver Code Ends
// User function Template for Java

/*
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

static class Solution {
    // Function that constructs BST from its preorder traversal.
    static class INT {
		int index;
		INT(int d) { index = d; }
	}
	
	Node constructBST(int pre[], INT preIndex, int low, int high, int size){

		if (preIndex.index >= size || low > high) {
			return null;
		}
		Node root = new Node(pre[preIndex.index]);
		preIndex.index = preIndex.index + 1;
		if (low == high) {
			return root;
		}

		int i;
		for (i = low; i <= high; ++i) {
			if (pre[i] > root.data) {
				break;
			}
		}
		root.left = constructBST(pre, preIndex, preIndex.index, i - 1, size);
		root.right = constructBST(pre, preIndex, i, high, size);
		return root;
	}
	
    public Node Bst(int pre[], int size) {
        // code here
         INT preIndex = new INT(0);
        return constructBST(pre, preIndex, 0 , size - 1, size);
    }
}

//{ Driver Code Starts.

    public static void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}
// } Driver Code Ends