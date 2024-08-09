//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
           if (s.length() < p.length()) {
            return "-1";
        }

        // Create frequency maps for characters in p and the current window
        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        // Fill pFreq
        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }

        int start = 0, minStart = -1, minLength = Integer.MAX_VALUE;
        int count = 0;
        
        for (int end = 0; end < s.length(); end++) {
            // Expand the window
            char currentChar = s.charAt(end);
            windowFreq[currentChar - 'a']++;

            // If the current character is required and we haven't exceeded its frequency in p
            if (pFreq[currentChar - 'a'] > 0 && windowFreq[currentChar - 'a'] <= pFreq[currentChar - 'a']) {
                count++;
            }

            // If we have all required characters
            if (count == p.length()) {
                // Try to minimize the window
                while (start <= end && (pFreq[s.charAt(start) - 'a'] == 0 || 
                       windowFreq[s.charAt(start) - 'a'] > pFreq[s.charAt(start) - 'a'])) {
                    windowFreq[s.charAt(start) - 'a']--;
                    start++;
                }

                // Update minimum window
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    minStart = start;
                }
            }
        }

        return minStart == -1 ? "-1" : s.substring(minStart, minStart + minLength);
    }
}