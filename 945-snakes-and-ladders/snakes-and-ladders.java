class Solution {
      private int boardSize;
      public int snakesAndLadders(int[][] board) {
         boardSize = board.length; 
        Deque<Integer> queue = new ArrayDeque<>(); 
        queue.offer(1);
        boolean[] visited = new boolean[boardSize * boardSize + 1]; 
        visited[1] = true;
        int moves = 0; 
      
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; --i) { 
                int current = queue.poll(); 
                if (current == boardSize * boardSize) { 
                    return moves;
                }
                for (int k = current + 1; k <= Math.min(current + 6, boardSize * boardSize); ++k) {
                    int[] position = convertToPosition(k); 
                    int next = k;
                    if (board[position[0]][position[1]] != -1) {
                        next = board[position[0]][position[1]]; 
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            moves++; 
        }
        return -1; 
    }

    private int[] convertToPosition(int squareNum) {
        int row = (squareNum - 1) / boardSize;
        int col = (squareNum - 1) % boardSize;
        if (row % 2 == 1) {
            col = boardSize - 1 - col; 
        }
        return new int[] {boardSize - 1 - row, col};
    }
}