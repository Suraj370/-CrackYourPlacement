class Solution {
  public int countArrangement(int n) {
    final String filled = "x".repeat(n + 1);
    StringBuilder sb = new StringBuilder(filled);
    Map<String, Integer> memo = new HashMap<>();

    return dfs(n, 1, sb, memo);
  }

  private int dfs(int N, int num, StringBuilder sb, Map<String, Integer> memo) {
    if (num == N + 1)
      return 1;
    final String filled = sb.toString();
    if (memo.containsKey(filled))
      return memo.get(filled);

    int count = 0;

    for (int i = 1; i <= N; ++i)
      if (sb.charAt(i) == 'x' && (num % i == 0 || i % num == 0)) {
        sb.setCharAt(i, 'o');
        count += dfs(N, num + 1, sb, memo);
        sb.setCharAt(i, 'x');
      }

    memo.put(filled, count);
    return count;
  }
}