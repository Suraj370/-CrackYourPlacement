//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[n];
        backtrack(arr, new ArrayList<>(), used, result);
        return result;
    }
    
    private static void backtrack(ArrayList<Integer> arr, ArrayList<Integer> current, boolean[] used, ArrayList<ArrayList<Integer>> result) {
        if (current.size() == arr.size()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        Set<Integer> usedAtThisPosition = new HashSet<>();
        
        for (int i = 0; i < arr.size(); i++) {
            if (used[i] || usedAtThisPosition.contains(arr.get(i))) continue;
            
            used[i] = true;
            usedAtThisPosition.add(arr.get(i));
            current.add(arr.get(i));
            
            backtrack(arr, current, used, result);
            
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}