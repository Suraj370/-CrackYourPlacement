//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.findPages(n, a, m));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        if (m > n) return -1; // Not enough books for all students
        
        long sum = 0;
        int max = 0;
        for (int pages : arr) {
            sum += pages;
            max = Math.max(max, pages);
        }
        
        long low = max;
        long high = sum;
        long result = -1;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isAllocationPossible(arr, n, m, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return result;
    }
    
    private static boolean isAllocationPossible(int[] arr, int n, int m, long maxPages) {
        int studentsRequired = 1;
        long currentPages = 0;
        
        for (int pages : arr) {
            if (currentPages + pages > maxPages) {
                studentsRequired++;
                currentPages = pages;
                if (studentsRequired > m) return false;
            } else {
                currentPages += pages;
            }
        }
        
        return true;
    }
}