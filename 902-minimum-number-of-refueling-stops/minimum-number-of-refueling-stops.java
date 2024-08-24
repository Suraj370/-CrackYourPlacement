class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int numStations = stations.length; 
        int prevPosition = 0; 
        int numRefuels = 0; 


        for (int i = 0; i <= numStations; i++) {
            int distance = (i < numStations ? stations[i][0] : target) - prevPosition;
            startFuel -= distance;
            while (startFuel < 0 && !maxHeap.isEmpty()) {
                startFuel += maxHeap.poll();
                numRefuels++; 
            }
            if (startFuel < 0) {
                return -1;
            }
            if (i < numStations) {
                maxHeap.offer(stations[i][1]);
                prevPosition = stations[i][0];
            }
        }
        return numRefuels;
    }
}