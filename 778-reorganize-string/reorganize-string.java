
class Solution {
    public String reorganizeString(String s) {
        // Count the frequency of each character
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }
        
        // Create a max heap (PriorityQueue)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        // Add characters and their frequencies to the heap
        for (int i = 0; i < 26; i++) {
            if (charCounts[i] > 0) {
                pq.offer(new int[]{i, charCounts[i]});
            }
        }
        
        // If the most frequent character appears more than (n+1)/2 times, return ""
        if (pq.peek()[1] > (s.length() + 1) / 2) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        int[] prev = new int[]{-1, 0};
        
        while (!pq.isEmpty() || prev[1] > 0) {
            if (pq.isEmpty() && prev[1] > 0) {
                return "";  // Cannot reorganize
            }
            
            int[] current = pq.poll();
            result.append((char)(current[0] + 'a'));
            current[1]--;
            
            if (prev[1] > 0) {
                pq.offer(prev);
            }
            
            prev = current;
        }
        
        return result.toString();
    }
}