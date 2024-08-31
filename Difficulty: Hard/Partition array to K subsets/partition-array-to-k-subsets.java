//{ Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method */

class Solution {
    public boolean isKPartitionPossible(int a[], int n, int k) {
        if (k == 1) return true;  
        if (n < k) return false; 
        int sum = 0;
        for (int num : a) sum += num;
        
        if (sum % k != 0) return false; 
        
        int targetSum = sum / k;
        boolean[] used = new boolean[n];
        
        return canPartition(a, used, 0, k, 0, targetSum);
    }
    
    private boolean canPartition(int[] a, boolean[] used, int start, int k, int currentSum, int targetSum) {
        if (k == 1) return true;
        
        if (currentSum == targetSum) {
            return canPartition(a, used, 0, k - 1, 0, targetSum);
        }
        
        for (int i = start; i < a.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (canPartition(a, used, i + 1, k, currentSum + a[i], targetSum)) {
                    return true;
                }
                used[i] = false;
            }
        }
        
        return false;
    }
}
