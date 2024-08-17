class Solution {
    public int search(int[] A, int target) {
				if(A == null || A.length == 0) return -1;
				int n = A.length;
				
				int left = 0, right = n - 1;
				
				while (left + 1 < right) {
            int mid = left + ((right - left) >> 1);
            if (A[mid] == target)  return mid;
            if (A[left] < A[right]) {
                if (A[mid] < target) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                if (A[mid] > A[left]) {
                    if (A[mid] > target && A[left] <= target) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                } else {
                    if (A[mid] < target && A[right] >= target) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }
            }
        }
		if(A[left] == target){
				return left;
		}
	  if(A[right] == target){
				return right;
		}
				
		return -1;
        
    }
}