class Solution {
    private boolean solved; // Variable to determine if the puzzle is solved
    private char[][] board; // The Sudoku board
    // List for tracking empty cells (those with '.')
    private List<Integer> emptyCells = new ArrayList<>();
    // Arrays to track the used numbers in rows, columns, and blocks
    private boolean[][] usedInRow = new boolean[9][9];
    private boolean[][] usedInColumn = new boolean[9][9];
    private boolean[][][] usedInBlock = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {
        this.board = board;
        // Initialize the tracking structures and find the empty positions
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    emptyCells.add(i * 9 + j); // Record the position of an empty cell
                } else {
                    // Convert char to int value ranging from 0-8
                    int value = board[i][j] - '1';
                    // Mark the value as used in the corresponding row, column, and block
                    usedInRow[i][value] = true;
                    usedInColumn[j][value] = true;
                    usedInBlock[i / 3][j / 3][value] = true;
                }
            }
        }
        // Begin the recursive depth-first search to solve the puzzle
        dfs(0);
    }

    private void dfs(int index) {
        if (index == emptyCells.size()) {
            solved = true;
            return;
        }
        int i = emptyCells.get(index) / 9;
        int j = emptyCells.get(index) % 9;

        for (int value = 0; value < 9; ++value) {
            if (!usedInRow[i][value] && !usedInColumn[j][value] && !usedInBlock[i / 3][j / 3][value]) {
                usedInRow[i][value] = true;
                usedInColumn[j][value] = true;
                usedInBlock[i / 3][j / 3][value] = true;
                board[i][j] = (char) (value + '1');
                dfs(index + 1);
                if (solved) {
                    return;
                }
                usedInRow[i][value] = false;
                usedInColumn[j][value] = false;
                usedInBlock[i / 3][j / 3][value] = false;
            }
        }
    }
}