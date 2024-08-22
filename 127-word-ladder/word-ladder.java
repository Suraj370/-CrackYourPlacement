public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null) return 0;
        if (beginWord.equals(endWord)) return 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        Set<String> set = new HashSet<>();
        if (!dict.contains(endWord)) return 0;
        queue.offer(beginWord);
        int res = 1;
        set.add(beginWord);
        // dict.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size(); 
            for (int s = 0; s < size; s++) {
                String prev = queue.poll();
                for (int i = 0; i < prev.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String curt = prev.substring(0, i) + c + prev.substring(i + 1);
                        if (curt.equals(endWord)) return res + 1;
                        if (dict.contains(curt) && !set.contains(curt)) {
                            queue.offer(curt);
                            set.add(curt);
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }
}