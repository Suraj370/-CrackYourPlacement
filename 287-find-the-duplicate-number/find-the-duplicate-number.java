class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(m.containsKey(nums[i]))
                return nums[i];
            m.put(nums[i], 0);
        }
        return 0;
    }
}