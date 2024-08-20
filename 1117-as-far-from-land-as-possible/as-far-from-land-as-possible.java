class Solution {
    public int maxDistance(int[][] grid) {
        int gridSize = grid.length;
        Deque<int[]> queue = new ArrayDeque<>();
      
        for (int i = 0; i < gridSize; ++i) {
            for (int j = 0; j < gridSize; ++j) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
      
        int maxDistance = -1;

        if (queue.isEmpty() || queue.size() == gridSize * gridSize) {
            return maxDistance;
        }
     
        int[] directions = {-1, 0, 1, 0, -1}; 
      
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = currentSize; i > 0; --i) {
                int[] point = queue.poll();
              
                
                for (int k = 0; k < 4; ++k) { 
                    int x = point[0] + directions[k];
                    int y = point[1] + directions[k + 1];
                  
                    if (x >= 0 && x < gridSize && y >= 0 && y < gridSize && grid[x][y] == 0) {
                        grid[x][y] = 1; 
                        queue.offer(new int[] {x, y});
                    }
                }
            }
            ++maxDistance;
        }
        return maxDistance;
    }
}