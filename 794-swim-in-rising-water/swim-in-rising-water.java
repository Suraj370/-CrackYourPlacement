class Solution {
    static int[] deltaRow = {-1, 0, 1, 0};
    static int[] deltaCol = {0, 1, 0, -1};
    boolean isEndReachable(int[][] grid, int t) {
        if (grid[0][0] > t) { // starting elevation can't exceed t
            return false;
        }
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> q = new LinkedList<int[]>();
        int[] start = {0, 0}; 
        q.add(start);
        vis[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            for (int i = 0; i < 4; i++) {
                int newRow = curRow + deltaRow[i];
                int newCol = curCol + deltaCol[i];
                if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) { 
                    continue;
                }
                if (vis[newRow][newCol]) { 
                    continue;
                }
                if (grid[newRow][newCol] > t) { 
                    continue;
                }
                vis[newRow][newCol] = true;
                int[] destination = {newRow, newCol};
                q.add(destination);
            }
        }
        return vis[n - 1][n - 1];
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int low = -1; 
        int high = n * n;
        int mid = (low + high) / 2;
        while (low + 1 < high) {
            if (isEndReachable(grid, mid)) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (low + high) / 2;
        }
        return high;
    }
}