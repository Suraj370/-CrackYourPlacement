class Solution {
  private int[] parent; 

    public int removeStones(int[][] stones) {
        int n = 10010; 
        parent = new int[n << 1]; 
        for (int i = 0; i < parent.length; ++i) {
            parent[i] = i; 
        }
        for (int[] stone : stones) {
     
            parent[find(stone[0])] = find(stone[1] + n);
        }
        Set<Integer> uniqueRoots = new HashSet<>(); 
        for (int[] stone : stones) {
            uniqueRoots.add(find(stone[0]));
        }
    
        return stones.length - uniqueRoots.size();
    }

    private int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}