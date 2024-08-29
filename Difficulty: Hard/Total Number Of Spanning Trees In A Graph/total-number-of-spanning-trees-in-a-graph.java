//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            
            
            int[][] graph = IntMatrix.input(br, a[1], 2);
            
            Solution obj = new Solution();
            int res = obj.countSpanningTrees(graph,a[0],a[1]);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countSpanningTrees(int[][] graph, int n, int m) {
        // Create the Laplacian matrix
        int[][] laplacian = new int[n][n];
        
        // Fill the Laplacian matrix
        for (int[] edge : graph) {
            int u = edge[0];
            int v = edge[1];
            laplacian[u][u]++;
            laplacian[v][v]++;
            laplacian[u][v]--;
            laplacian[v][u]--;
        }
        
        // Remove the last row and column to create the cofactor
        int[][] cofactor = new int[n-1][n-1];
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                cofactor[i][j] = laplacian[i][j];
            }
        }
        
        // Calculate the determinant of the cofactor
        return Math.abs(determinant(cofactor));
    }
    
    // Function to calculate determinant using recursion
    private static int determinant(int[][] matrix) {
        int n = matrix.length;
        
        if (n == 1) {
            return matrix[0][0];
        }
        
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        
        int det = 0;
        for (int j = 0; j < n; j++) {
            int[][] subMatrix = new int[n-1][n-1];
            for (int i = 1; i < n; i++) {
                int k = 0;
                for (int l = 0; l < n; l++) {
                    if (l != j) {
                        subMatrix[i-1][k] = matrix[i][l];
                        k++;
                    }
                }
            }
            det += Math.pow(-1, j) * matrix[0][j] * determinant(subMatrix);
        }
        
        return det;
    }
}
        
