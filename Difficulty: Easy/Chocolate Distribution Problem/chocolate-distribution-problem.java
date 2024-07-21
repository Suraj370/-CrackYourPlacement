//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
                {
                    int x = sc.nextInt();
                    arr.add(x);
                }
            int m = sc.nextInt();
            
            Solution ob = new Solution();
            
    		System.out.println(ob.findMinDiff(arr,n,m));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        if(n == 0 || m == 0){
            return 0;
        }
        Collections.sort(a);
        if(n < m){
            return -1;
        }
        int min = Integer.MAX_VALUE;
     
        for(int i =0; i < n; i++){
            int window = i + m - 1;
            if(window >= n)
                break;
            int diff = a.get(window) - a.get(i);
            min = Math.min(min, diff);
        }
        return min;
    }
}