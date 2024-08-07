//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int solveWordWrap(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        
        // Initialize last word's cost
        dp[n-1] = 0;
        
        // Calculate cost for each starting position
        for (int i = n-2; i >= 0; i--) {
            int currLen = -1; // -1 to account for space between words
            dp[i] = Integer.MAX_VALUE;
            
            for (int j = i; j < n; j++) {
                currLen += nums[j] + 1; // Add word length and space
                
                if (currLen > k) {
                    break;
                }
                
                int cost;
                if (j == n-1) {
                    cost = 0; // Last line has no extra space cost
                } else {
                    cost = (k - currLen) * (k - currLen);
                }
                
                int totalCost = cost + (j == n-1 ? 0 : dp[j+1]);
                dp[i] = Math.min(dp[i], totalCost);
            }
        }
        
        return dp[0];
    }
}