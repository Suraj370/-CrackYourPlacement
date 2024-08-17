class Solution {
    public int splitArray(int[] nums, int maxSplits) {
        int maxElement = 0, sumRange = 0;

        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
            sumRange += num;
        }

        while (maxElement < sumRange) {
            int mid = (maxElement + sumRange) >> 1; 
          
            if (isSplitPossible(nums, mid, maxSplits)) {
                sumRange = mid; 
            } else {
                maxElement = mid + 1; 
            }
        }

        return maxElement;
    }

    private boolean isSplitPossible(int[] nums, int maxSubarraySum, int maxSplits) {
        int subarraySum = (1 << 30), subarrayCount = 0; 
      
        for (int num : nums) {
            subarraySum += num;

            if (subarraySum > maxSubarraySum) {
                subarrayCount++;
                subarraySum = num;
            }
        }

        return subarrayCount <= maxSplits;
    }
}