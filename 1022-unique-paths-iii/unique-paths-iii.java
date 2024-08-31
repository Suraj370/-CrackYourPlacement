class Solution {
    private int height;
    private int width;
    private int res;
    private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int uniquePathsIII(int[][] grid) {
        height = grid.length;
        width = grid[0].length;
        int count = 0;
        int startX = -1, startY = -1;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                }else if(grid[i][j] == 0)
                    count++;
            }
        }
        boolean[][] visited = new boolean[height][width];
        visited[startX][startY] = true;
        dfs(startX, startY, grid, count, visited);
        return this.res;
    }
    private void dfs(int row, int col, int[][] grid, int count, boolean[][] visited){
        if(count == -1 && grid[row][col] == 2) this.res++;
        else{
            int tx = 0, ty = 0;
            for(int d = 0; d < 4; d++){
                tx = row + dir[d][0];
                ty = col + dir[d][1];
                if(tx >= 0 && tx < height && ty >= 0 && ty < width && !visited[tx][ty] && grid[tx][ty] != -1){
                    visited[tx][ty] = true;
                    dfs(tx, ty, grid, count - 1, visited);
                    visited[tx][ty] = false;
                }
            }
        }
    }
}