class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;

        for (int i = 0; i < nums.length; ++i) {
            while (!stack.isEmpty() && stack.peek() > nums[i] && stack.size() + n - i > k) {
                stack.pop();
            }
          
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }
      
        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; --i) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}