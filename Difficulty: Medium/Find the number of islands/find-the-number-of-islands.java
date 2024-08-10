//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
 public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
        return 0;
    }
    
    int numIslands = 0;
    int rows = grid.length;
    int cols = grid[0].length;
    
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == '1') {
                numIslands++;
                dfs(grid, i, j);
            }
        }
    }
    
    return numIslands;
}

private void dfs(char[][] grid, int row, int col) {
    int rows = grid.length;
    int cols = grid[0].length;
    
    if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] != '1') {
        return;
    }
    
    // Mark the current cell as visited
    grid[row][col] = '0';
    
    // Directions array for all 8 adjacent cells
    int[][] directions = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1},           {0, 1},
        {1, -1},  {1, 0},  {1, 1}
    };
    
    // Recursively visit all adjacent cells (including diagonals)
    for (int[] dir : directions) {
        dfs(grid, row + dir[0], col + dir[1]);
    }
}
}