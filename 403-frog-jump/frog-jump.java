class Solution {
    private Boolean[][] memo; // memoization array to store results of subproblems
    private Map<Integer, Integer> positionMap = new HashMap<>(); // maps stone's value to its index
    private int[] stones; // array of stones
    private int numOfStones; // number of stones

    // Determines if you can cross the river by jumping on stones
    public boolean canCross(int[] stones) {
        numOfStones = stones.length;
        memo = new Boolean[numOfStones][numOfStones];
        this.stones = stones;
        for (int i = 0; i < numOfStones; ++i) {
            positionMap.put(stones[i], i);
        }
        return dfs(0, 0);
    }

    private boolean dfs(int index, int lastJumpSize) {
        if (index == numOfStones - 1) {
            return true;
        }
        if (memo[index][lastJumpSize] != null) {
            return memo[index][lastJumpSize];
        }
        for (int currentJumpSize = lastJumpSize - 1; currentJumpSize <= lastJumpSize + 1; ++currentJumpSize) {
            if (currentJumpSize > 0) {
                int nextPosition = stones[index] + currentJumpSize; 
                if (positionMap.containsKey(nextPosition) && dfs(positionMap.get(nextPosition), currentJumpSize)) {
                    return memo[index][lastJumpSize] = true;
                }
            }
        }
        return memo[index][lastJumpSize] = false;
    }
}
