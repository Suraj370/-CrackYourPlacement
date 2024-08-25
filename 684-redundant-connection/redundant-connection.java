class Solution {

    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {

        parent = new int[1010];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            if (find(node1) == find(node2)) {
                return edge;
            }

            parent[find(node1)] = find(node2);
        }
      
   
        return null;
    }

    private int find(int node) {

        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }
}