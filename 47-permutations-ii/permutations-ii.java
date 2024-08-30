class Solution {
    
    private List<List<Integer>> permutations = new ArrayList<>();
    private List<Integer> tempPermutation = new ArrayList<>();
    private int[] numbers;
    private boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.numbers = nums;
        visited = new boolean[nums.length];
        dfs(0);
        return permutations;
    }

    private void dfs(int index) {
        if (index == numbers.length) {
            permutations.add(new ArrayList<>(tempPermutation));
            return;
        }
        for (int i = 0; i < numbers.length; ++i) {
            if (visited[i] || (i > 0 && numbers[i] == numbers[i - 1] && !visited[i - 1])) {
                continue;
            }
            tempPermutation.add(numbers[i]);
            visited[i] = true;
            dfs(index + 1);
            visited[i] = false;
            tempPermutation.remove(tempPermutation.size() - 1);
        }
    }
}