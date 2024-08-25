
class Solution {
    private int currentTime;
    private List<Integer>[] graph;
    private List<List<Integer>> criticalConnectionsList = new ArrayList<>();
    private int[] discoveryTime;
    private int[] lowTime;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        initializeGraph(n, connections);

        tarjanAlgorithm(0, -1);

        return criticalConnectionsList;
    }

    private void initializeGraph(int numberOfNodes, List<List<Integer>> connections) {
        graph = new List[numberOfNodes];
        Arrays.setAll(graph, k -> new ArrayList<>());
        discoveryTime = new int[numberOfNodes];
        lowTime = new int[numberOfNodes];
        for (List<Integer> edge : connections) {
            int node1 = edge.get(0);
            int node2 = edge.get(1);
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
    }

    private void tarjanAlgorithm(int node, int parent) {
        discoveryTime[node] = lowTime[node] = ++currentTime;

        for (int neighbor : graph[node]) {
            if (neighbor == parent) {
                continue;
            }

            if (discoveryTime[neighbor] == 0) {
                tarjanAlgorithm(neighbor, node);

                lowTime[node] = Math.min(lowTime[node], lowTime[neighbor]);

                if (lowTime[neighbor] > discoveryTime[node]) {
                    criticalConnectionsList.add(Arrays.asList(node, neighbor));
                }
            } else {
                lowTime[node] = Math.min(lowTime[node], discoveryTime[neighbor]);
            }
        }
    }
}
