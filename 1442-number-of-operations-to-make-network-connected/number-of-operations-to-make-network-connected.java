class Solution {
    private int[] parent;

    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
      
        int redundantConnections = 0;
      
        for (int[] connection : connections) {
            int computer1 = connection[0];
            int computer2 = connection[1];
          
            if (find(computer1) == find(computer2)) {
                ++redundantConnections;
            } else {
                parent[find(computer1)] = find(computer2);
                --n;
            }
        }
      
  
        return n - 1 > redundantConnections ? -1 : n - 1;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}