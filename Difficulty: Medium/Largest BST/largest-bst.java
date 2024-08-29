//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution {
    
    // A helper class to store information about each subtree
    static class NodeInfo {
        int size;      
        int min;       
        int max;      
        boolean isBST;  
        
        NodeInfo(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
    
    static int largestBst(Node root) {
        return largestBSTSubtree(root).size;
    }
    
    static NodeInfo largestBSTSubtree(Node root) {
        if (root == null) {
            return new NodeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        
        NodeInfo left = largestBSTSubtree(root.left);
        NodeInfo right = largestBSTSubtree(root.right);
        
        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {

            int min = Math.min(root.data, left.min);
            int max = Math.max(root.data, right.max);
            int size = left.size + right.size + 1;
            return new NodeInfo(size, min, max, true);
        } else {
            int maxSize = Math.max(left.size, right.size);
            return new NodeInfo(maxSize, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
        }
    }
}