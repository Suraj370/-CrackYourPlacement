class Solution {
    // Memoization cache to hold the results of subproblems
    private int[][] memo;

    // Entry method for calculating the minimum number of moves
    public int superEggDrop(int k, int n) {
        memo = new int[n + 1][k + 1];
        return findMinMoves(n, k);
    }

    private int findMinMoves(int floors, int eggs) {
        if (floors < 1) {
            return 0;
        }

        if (eggs == 1) {
            return floors;
        }
        if (memo[floors][eggs] != 0) {
            return memo[floors][eggs];
        }

        int low = 1, high = floors;
        while (low < high) {

            int mid = (low + high + 1) >> 1;
          

            int a = findMinMoves(mid - 1, eggs - 1);
            int b = findMinMoves(floors - mid, eggs);

            if (a <= b) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
      
        memo[floors][eggs] = Math.max(findMinMoves(low - 1, eggs - 1), findMinMoves(floors - low, eggs)) + 1;

        return memo[floors][eggs];
    }
}
