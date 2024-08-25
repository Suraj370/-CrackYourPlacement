class Solution {
    // f stores the computed results to avoid repetitive calculations (memoization)
    private int[][][] memo;
    // boxes is the array representing the input boxes
    private int[] boxes;

    public int removeBoxes(int[] boxes) {
        this.boxes = boxes;
        int n = boxes.length;
        memo = new int[n][n][n]; 
        return dfs(0, n - 1, 0); 
    }

    
    private int dfs(int start, int end, int consecutive) {
        if (start > end) {
            return 0; 
        }

        while (start < end && boxes[end] == boxes[end - 1]) {
            --end;
            ++consecutive;
        }

        if (memo[start][end][consecutive] > 0) {
            return memo[start][end][consecutive];
        }

        int maxPoints = dfs(start, end - 1, 0) + (consecutive + 1) * (consecutive + 1);

        for (int i = start; i < end; ++i) {
            if (boxes[i] == boxes[end]) {
                int points = 
                    dfs(i + 1, end - 1, 0) +  
                    dfs(start, i, consecutive + 1); 
                maxPoints = Math.max(maxPoints, points);
            }
        }

        memo[start][end][consecutive] = maxPoints;
        return maxPoints;
    }
}
