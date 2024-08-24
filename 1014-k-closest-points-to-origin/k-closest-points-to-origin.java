class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
        (p1, p2)-> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for(int []p : points){
            pq.offer(p);
            if(pq.size() > k)
                pq.poll();
        }
        int size = Math.min(k, pq.size());
        int [][]res = new int[size][2];
        int i = size;
        while(!pq.isEmpty()){
            res[--i] = pq.poll();
        }
        return res;
    }
}