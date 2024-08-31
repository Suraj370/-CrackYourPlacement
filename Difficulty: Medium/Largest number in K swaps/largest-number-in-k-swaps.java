//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int k = sc.nextInt();
                    String str = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.findMaximumNum(str, k));
                }
        }
}
// } Driver Code Ends




class Solution {
    static String max;

    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k) {
        max = str;
        findMaximumNumUtil(str.toCharArray(), k, 0);
        return max;
    }

    private static void findMaximumNumUtil(char[] strArr, int k, int idx) {
        if (k == 0 || idx == strArr.length) {
            String curr = new String(strArr);
            if (curr.compareTo(max) > 0) {
                max = curr;
            }
            return;
        }

        char maxChar = strArr[idx];
        for (int i = idx + 1; i < strArr.length; i++) {
            if (strArr[i] > maxChar) {
                maxChar = strArr[i];
            }
        }

        if (maxChar != strArr[idx]) {
            for (int i = idx + 1; i < strArr.length; i++) {
                if (strArr[i] == maxChar) {
                    swap(strArr, idx, i);
                    findMaximumNumUtil(strArr, k - 1, idx + 1);
                    swap(strArr, idx, i); // backtrack
                }
            }
        }

        findMaximumNumUtil(strArr, k, idx + 1);
    }

    private static void swap(char[] strArr, int i, int j) {
        char temp = strArr[i];
        strArr[i] = strArr[j];
        strArr[j] = temp;
    }
}