class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int psum = 0, cnt = 0;
        m.put(0, 1);
        int n = nums.length;
        for(int i = 0; i < n; i++){
            psum = psum + nums[i];
            if(m.containsKey(psum - k))
                cnt = cnt + m.get(psum - k);
            m.put(psum, m.getOrDefault(psum ,0) + 1);
        }
        return cnt;
    }
}