//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
     private static final int PRIME = 101;
     
     private long calculateHash(String str, int end) {
        long hash = 0;
        for (int i = 0; i < end; i++) {
            hash = (hash * 26 + (str.charAt(i) - 'a')) % PRIME;
        }
        return hash;
    }
    
     private long recalculateHash(String str, int oldIndex, int newIndex, long oldHash, int patternLength, long pow) {
        long newHash = oldHash;
        newHash = (newHash - (str.charAt(oldIndex) - 'a') * pow) % PRIME;
        newHash = (newHash * 26 + (str.charAt(newIndex) - 'a')) % PRIME;
        return (newHash + PRIME) % PRIME;  // Ensure positive hash
    }
    
    private boolean checkEqual(String str1, int start1, int end1, String str2, int start2, int end2) {
        if (end1 - start1 != end2 - start2) {
            return false;
        }
        while (start1 <= end1 && start2 <= end2) {
            if (str1.charAt(start1) != str2.charAt(start2)) {
                return false;
            }
            start1++;
            start2++;
        }
        return true;
    }
    
    ArrayList<Integer> search(String pattern, String text)
    {
        // your code here
        ArrayList<Integer> result = new ArrayList<>();
        int patternLength = pattern.length();
        int textLength = text.length();
        
        if (patternLength > textLength) {
            return result;
        }
        
        // Calculate hash value for pattern and first window of text
        long patternHash = calculateHash(pattern, patternLength);
        long textHash = calculateHash(text, patternLength);
        
        // Calculate (a^(m-1)) % PRIME
        long pow = 1;
        for (int i = 0; i < patternLength - 1; i++) {
            pow = (pow * 26) % PRIME;
        }
        
        for (int i = 0; i <= textLength - patternLength; i++) {
            // Check if hash values match
            if (patternHash == textHash) {
                // If hash match, check for exact match
                if (checkEqual(text, i, i + patternLength - 1, pattern, 0, patternLength - 1)) {
                    result.add(i + 1);  // Add 1 to convert to 1-based index
                }
            }
            
            // Calculate hash for next window
            if (i < textLength - patternLength) {
                textHash = recalculateHash(text, i, i + patternLength, textHash, patternLength, pow);
            }
        }
        
        return result;
    }
}