class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCounts = new int[26];
        int maxFrequency = 0;
        for (char task : tasks) {
            int index = task - 'A';
            taskCounts[index]++;
            maxFrequency = Math.max(maxFrequency, taskCounts[index]);
        }
        int maxFrequencyTasks = 0;
        for (int count : taskCounts) {
            if (count == maxFrequency) {
                maxFrequencyTasks++;
            }
        }
        int minScheduleLength = Math.max(tasks.length, (maxFrequency - 1) * (n + 1) + maxFrequencyTasks);

        return minScheduleLength;

    }
}