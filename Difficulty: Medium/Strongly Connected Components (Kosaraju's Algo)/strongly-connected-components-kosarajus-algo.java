//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Step 1: Perform DFS and store the finishing time of each vertex in a stack
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++)
        {
            if(!visited[i])
                dfs1(i, adj, visited, stack);
        }
        
        // Step 2: Transpose the graph
        ArrayList<ArrayList<Integer>> transposeAdj = new ArrayList<>();
        for(int i=0; i<V; i++)
            transposeAdj.add(new ArrayList<>());
        for(int i=0; i<V; i++)
        {
            for(int neighbor : adj.get(i))
            {
                transposeAdj.get(neighbor).add(i);
            }
        }
        
        // Step 3: Perform DFS on the transposed graph, starting from the vertices in the order of finishing times
        visited = new boolean[V];
        int scc = 0;
        while(!stack.isEmpty())
        {
            int curr = stack.pop();
            if(!visited[curr])
            {
                dfs2(curr, transposeAdj, visited);
                scc++;
            }
        }
        
        return scc;
    }
    
    private void dfs1(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack)
    {
        visited[node] = true;
        for(int neighbor : adj.get(node))
        {
            if(!visited[neighbor])
                dfs1(neighbor, adj, visited, stack);
        }
        stack.push(node);
    }
    
    private void dfs2(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited)
    {
        visited[node] = true;
        for(int neighbor : adj.get(node))
        {
            if(!visited[neighbor])
                dfs2(neighbor, adj, visited);
        }
    }
}