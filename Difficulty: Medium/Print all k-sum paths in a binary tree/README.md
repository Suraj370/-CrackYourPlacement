# Print all k-sum paths in a binary tree
A binary tree and a number k are given. Print every path in the tree with sum of the nodes in the path as k. 

A path can start from any node and end at any node and must be downward only, i.e. they need not be root node and leaf node; and negative numbers can also be there in the tree.

Examples: 
```
Input : k = 5  
Root of below binary tree:
           1
        /     \
      3        -1
    /   \     /   \
  2     1   4       5                        
      /   /    \         \                    
   1   1          2          6    
                       
Output :
3 2 
3 1 1 
1 3 1 
4 1 
1 -1 4 1 
-1 4 2 
5 
1 -1 5
```
