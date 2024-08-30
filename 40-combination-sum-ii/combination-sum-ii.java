class Solution {
     private List<List<Integer>> combinations = new ArrayList<>(); 
    private List<Integer> combination = new ArrayList<>(); 
    private int[] sortedCandidates; 
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
          Arrays.sort(candidates); 
          sortedCandidates = candidates; 
          backtrack(0, target); 
          return combinations;
    }

     private void backtrack(int startIndex, int remainingSum) {
        // If the remaining sum is 0, the current combination is a valid combination.
        if (remainingSum == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        // If the startIndex is out of bounds or the smallest candidate is greater than the remainingSum, there are no valid combinations.
        if (startIndex >= sortedCandidates.length || remainingSum < sortedCandidates[startIndex]) {
            return;
        }
        // Iterate through the candidates starting from startIndex.
        for (int i = startIndex; i < sortedCandidates.length; ++i) {
            // Skip duplicates to avoid redundant combinations.
            if (i > startIndex && sortedCandidates[i] == sortedCandidates[i - 1]) {
                continue;
            }
            // Add the candidate to the current combination.
            combination.add(sortedCandidates[i]);
            // Recursively call the method with the next index and the updated remaining sum.
            backtrack(i + 1, remainingSum - sortedCandidates[i]);
            // Backtrack: remove the last added candidate to try other candidates.
            combination.remove(combination.size() - 1);
        }
     }
}