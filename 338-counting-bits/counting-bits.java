class Solution {
    public int[] countBits(int n) {
           int[] bitCounts = new int[n + 1];
      
        for (int i = 1; i <= n; ++i) {
            
            bitCounts[i] = bitCounts[i & (i - 1)] + 1;
        }
      
        return bitCounts;
    }
}