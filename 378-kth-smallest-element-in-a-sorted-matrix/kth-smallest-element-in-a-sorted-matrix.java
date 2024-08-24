class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];
        int count = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
             count = func(matrix, mid, n);
            if(count < k) low = mid + 1;
            else high = mid - 1;
        }
        return low;

    }
    
     static int func(int nums[][], int k, int n){
	int row = n - 1, col = 0;
	int count = 0;

	while(row >= 0 && col < n){
	    if(nums[row][col] > k)  row--;
	    else{
		count += row + 1;
		col++;
	    }
	}
	return count;
    }
}