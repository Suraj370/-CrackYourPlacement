//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
         if (n == 0 || m == 0) return a;

        // Step 1: Mark 'O's on the border and their connected 'O's
        for (int i = 0; i < n; i++) {
            if (a[i][0] == 'O') dfs(a, i, 0, n, m);
            if (a[i][m-1] == 'O') dfs(a, i, m-1, n, m);
        }
        for (int j = 0; j < m; j++) {
            if (a[0][j] == 'O') dfs(a, 0, j, n, m);
            if (a[n-1][j] == 'O') dfs(a, n-1, j, n, m);
        }

        // Step 2: Convert remaining 'O's to 'X's and restore temporary marks
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O') {
                    a[i][j] = 'X';
                } else if (a[i][j] == 'T') {
                    a[i][j] = 'O';
                }
            }
        }

        return a;
    }
    
      private static void dfs(char[][] a, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || a[i][j] != 'O') {
            return;
        }

        a[i][j] = 'T'; // Mark as visited

        dfs(a, i+1, j, n, m);
        dfs(a, i-1, j, n, m);
        dfs(a, i, j+1, n, m);
        dfs(a, i, j-1, n, m);
    }
}