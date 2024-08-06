//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String str[] = read.readLine().trim().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
                
            Solution obj = new Solution();
            obj.radixSort(arr, n);
            for(int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
                
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
      static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
      static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; 
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;


        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
    static void radixSort(int arr[], int n) 
    { 
        // code here 
         int m = getMax(arr, n);
         
         for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    } 
    
}

