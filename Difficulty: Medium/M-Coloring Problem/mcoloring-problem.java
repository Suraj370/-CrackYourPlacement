//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
           int[] colors = new int[n]; // Array to store colors of vertices
        
        return colorGraph(graph, m, n, colors, 0);
    }
    
    private boolean colorGraph(boolean[][] graph, int m, int n, int[] colors, int vertex) {
        // Base case: If all vertices are colored, return true
        if (vertex == n) {
            return true;
        }
        
        // Try all colors for the current vertex
        for (int color = 1; color <= m; color++) {
            if (isSafe(graph, colors, vertex, color)) {
                // Assign the color to the current vertex
                colors[vertex] = color;
                
                // Recursively color the next vertex
                if (colorGraph(graph, m, n, colors, vertex + 1)) {
                    return true;
                }
                
                // If coloring is not possible, backtrack
                colors[vertex] = 0;
            }
        }
        
        // If no color can be assigned, return false
        return false;
    }
      private boolean isSafe(boolean[][] graph, int[] colors, int vertex, int color) {
        // Check if the color is safe to assign to the vertex
        for (int i = 0; i < graph.length; i++) {
            if (graph[vertex][i] && colors[i] == color) {
                return false;
            }
        }
        return true;
    }
}