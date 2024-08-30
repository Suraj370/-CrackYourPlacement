class Solution {
    public int mergeStones(int[] stones, int K) {
        int stoneCount = stones.length;
      
        if ((stoneCount - 1) % (K - 1) != 0) {
            return -1;
        }
      
        int[] prefixSums = new int[stoneCount + 1];
        for (int i = 1; i <= stoneCount; ++i) {
            prefixSums[i] = prefixSums[i - 1] + stones[i - 1];
        }
      
        final int infinity = 1 << 20;
        int[][][] dpTable = new int[stoneCount + 1][stoneCount + 1][K + 1];
        for (int[][] secondDimension : dpTable) {
            for (int[] thirdDimension : secondDimension) {
                Arrays.fill(thirdDimension, infinity);
            }
        }
        for (int i = 1; i <= stoneCount; ++i) {
            dpTable[i][i][1] = 0;
        }
      
        for (int length = 2; length <= stoneCount; ++length) {
            for (int i = 1; i + length - 1 <= stoneCount; ++i) {
                int j = i + length - 1;
                for (int piles = 1; piles <= K; ++piles) {

                    for (int mid = i; mid < j; ++mid) {
                        dpTable[i][j][piles] = Math.min(dpTable[i][j][piles], 
                                                         dpTable[i][mid][1] + dpTable[mid + 1][j][piles - 1]);
                    }
                }
                dpTable[i][j][1] = dpTable[i][j][K] + prefixSums[j] - prefixSums[i - 1];
            }
        }
        return dpTable[1][stoneCount][1];
    }
}