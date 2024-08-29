//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long getCount(int n) {
        // Define the allowed movements for each digit
        int[][] moves = {
            {0, 8}, // 0
            {1, 2, 4}, // 1
            {1, 2, 3, 5}, // 2
            {2, 3, 6}, // 3
            {1, 4, 5, 7}, // 4
            {2, 4, 5, 6, 8}, // 5
            {3, 5, 6, 9}, // 6
            {4, 7, 8}, // 7
            {5, 7, 8, 9, 0}, // 8
            {6, 8, 9} // 9
        };
        
        // Initialize dp array
        long[][] dp = new long[n][10];
        
        // Base case: for n = 1, there's one way for each digit
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        
        // Fill the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int next : moves[j]) {
                    dp[i][j] += dp[i-1][next];
                }
            }
        }
        
        // Sum up the total count for all digits
        long total = 0;
        for (int i = 0; i < 10; i++) {
            total += dp[n-1][i];
        }
        
        return total;
    }
}