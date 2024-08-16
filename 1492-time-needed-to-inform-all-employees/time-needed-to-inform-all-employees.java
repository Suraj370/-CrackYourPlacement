class Solution {
    private List<Integer>[] graph;

    private int[] informTime;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        graph = new List[n];
        Arrays.setAll(graph, k -> new ArrayList<>());
        this.informTime = informTime;

        for (int i = 0; i < n; ++i) {
            if (manager[i] >= 0) {
                graph[manager[i]].add(i);
            }
        }

        return dfs(headID);
    }

    private int dfs(int nodeId) {
        int maxTime = 0;

        for (int subordinateId : graph[nodeId]) {

            int currentTime = dfs(subordinateId) + informTime[nodeId];
            maxTime = Math.max(maxTime, currentTime);
        }

        return maxTime;
    }
}