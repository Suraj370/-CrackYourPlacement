class Solution {
    class Worker{
        double wageQualityRatio;
        int quality;
        
        Worker(int quality, int wage){
            this.quality =  quality;
            this.wageQualityRatio = (double) wage/quality;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int numWorkers = quality.length;
        Worker[] workers= new Worker[numWorkers];
        for(int i= 0; i < numWorkers; i++){
            workers[i] =  new Worker(quality[i], wage[i]); 
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a.wageQualityRatio, b.wageQualityRatio));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        double minCost = Double.MAX_VALUE;
        int totalQuality = 0;
        for(Worker worker : workers){

            totalQuality += worker.quality;
            maxHeap.offer(worker.quality);
            if(maxHeap.size() == k){
                minCost = Math.min(minCost, totalQuality * worker.wageQualityRatio);
                totalQuality -= maxHeap.poll();
            }
        }
        return minCost;


    }
}