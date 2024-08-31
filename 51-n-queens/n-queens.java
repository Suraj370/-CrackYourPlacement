public class Solution {
    private List<List<String>> solutions = new ArrayList<>();
  
    private int[] columns;
    private int[] diagonals;
    private int[] antiDiagonals;
  
    private String[][] board;
  
    private int size;

    public List<List<String>> solveNQueens(int n) {
        this.size = n;
        columns = new int[n];
        diagonals = new int[2 * n];
        antiDiagonals = new int[2 * n];
        board = new String[n][n];
      
        for (int i = 0; i < n; ++i) {
            Arrays.fill(board[i], ".");
        }
      
        depthFirstSearch(0);
        return solutions;
    }

    private void depthFirstSearch(int row) {
        if (row == size) {
            List<String> oneSolution = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                oneSolution.add(String.join("", board[i]));
            }
            solutions.add(oneSolution);
            return;
        }
        for (int col = 0; col < size; ++col) {
            if (columns[col] + diagonals[row + col] + antiDiagonals[size - row + col] == 0) {
                board[row][col] = "Q";
                columns[col] = diagonals[row + col] = antiDiagonals[size - row + col] = 1;
                depthFirstSearch(row + 1);
                columns[col] = diagonals[row + col] = antiDiagonals[size - row + col] = 0;
                board[row][col] = ".";
            }
        }
    }
}