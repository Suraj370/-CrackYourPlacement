class Solution {
    public int maxProduct(int[] nums) {
        
        int maxPos = nums[0];
        int minNeg = nums[0];
        int maxSoFar = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                maxPos = Math.max(maxPos * nums[i], nums[i]);

                minNeg = Math.min(minNeg * nums[i], nums[i]);
            }

            else if (nums[i] < 0) {
                int temp = maxPos;
                maxPos = Math.max(minNeg * nums[i], nums[i]);

                minNeg = Math.min(temp * nums[i], nums[i]);
            }
            maxSoFar = Math.max(maxPos, maxSoFar);
        }
        return maxSoFar;
    }
}