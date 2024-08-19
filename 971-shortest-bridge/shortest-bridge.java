class Solution {
    private int[] directions = {-1, 0, 1, 0, -1};
  
    private Deque<int[]> queue = new ArrayDeque<>();
  
    private int[][] grid;
  
    private int size;
  
    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        size = grid.length;
      
        boolean foundFirstIsland = false;
        for (int i = 0; i < size && !foundFirstIsland; ++i) {
            for (int j = 0; j < size; ++j) {
                if (grid[i][j] == 1) {
                    performDFS(i, j);
                    foundFirstIsland = true;
                    break; 
                }
            }
        }
      
        int steps = 0;
        while (true) {
            for (int i = queue.size(); i > 0; --i) {
                int[] point = queue.pollFirst();
                for (int k = 0; k < 4; ++k) {
                    int x = point[0] + directions[k];
                    int y = point[1] + directions[k + 1];
                  
                    if (x >= 0 && x < size && y >= 0 && y < size) {
                        if (grid[x][y] == 1) {
                            return steps;
                        }
 
                        if (grid[x][y] == 0) {
                            grid[x][y] = 2;
                            queue.offer(new int[] {x, y});
                        }
                    }
                }
            }
            ++steps; 
        }
    }

    private void performDFS(int i, int j) {
        grid[i][j] = 2;
        queue.offer(new int[] {i, j}); 
      
        for (int k = 0; k < 4; ++k) {
            int x = i + directions[k];
            int y = j + directions[k + 1];
          
            if (x >= 0 && x < size && y >= 0 && y < size && grid[x][y] == 1) {
                performDFS(x, y);
            }
        }
    }
}
