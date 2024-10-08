class Solution {
    public int minCost(String colors, int[] neededTime) {
        int prev = -1;
        int minTime = 0;

        for (int i = 0; i < colors.length(); i++) {
            if (prev == -1 || colors.charAt(prev) != colors.charAt(i)) {
                prev = i;
            } else {
                if (neededTime[prev] < neededTime[i]) {
                    minTime += neededTime[prev];
                    prev = i;
                } else {
                    minTime += neededTime[i];
                }
            }
        }

        return minTime;
    }
}