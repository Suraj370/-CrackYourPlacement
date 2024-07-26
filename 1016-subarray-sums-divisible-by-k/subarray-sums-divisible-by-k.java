class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        
        int res = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        
        for (int presum : prefixSum) {
            int remainder = presum % k >= 0 ? presum % k : presum % k + k;
            if (mp.containsKey(remainder)) {
                res += mp.get(remainder);
            }
            mp.put(remainder, mp.getOrDefault(remainder, 0) + 1);
        }
        
        return res;        
    }
}