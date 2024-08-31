//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> currentPartition = new ArrayList<>();
        boolean[][] isPalindrome = precomputePalindromes(S);
        
        backtrack(S, 0, isPalindrome, currentPartition, result);
        
        return result;
    }
    
    private static void backtrack(String s, int start, boolean[][] isPalindrome, 
                                  ArrayList<String> currentPartition, 
                                  ArrayList<ArrayList<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }
        
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome[start][end]) {
                currentPartition.add(s.substring(start, end + 1));
                backtrack(s, end + 1, isPalindrome, currentPartition, result);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }
    
    private static boolean[][] precomputePalindromes(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        
        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        
        // Check for substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
            }
        }
        
        // Check for substrings of length 3 or more
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                }
            }
        }
        
        return isPalindrome;
    }
}