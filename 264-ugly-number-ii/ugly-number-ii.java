import java.util.*;

class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        
        pq.offer(1L);
        seen.add(1L);
        
        long current = 0;
        for (int i = 0; i < n; i++) {
            current = pq.poll();
            
            long next = current * 2;
            if (seen.add(next)) {
                pq.offer(next);
            }
            
            next = current * 3;
            if (seen.add(next)) {
                pq.offer(next);
            }
            
            next = current * 5;
            if (seen.add(next)) {
                pq.offer(next);
            }
        }
        
        return (int) current;
    }
}