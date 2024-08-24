class Solution {
    public String removeDuplicates(String s, int k) {
         Deque<int[]> stack = new ArrayDeque<>();
      
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
          
            if (!stack.isEmpty() && stack.peek()[0] == index) {
                stack.peek()[1] = (stack.peek()[1] + 1) % k;
              
                if (stack.peek()[1] == 0) {
                    stack.pop();
                }
            } else {
                stack.push(new int[] {index, 1});
            }
        }
      
        StringBuilder result = new StringBuilder();
      
        for (var element : stack) {
            char c = (char) (element[0] + 'a');
            for (int i = 0; i < element[1]; ++i) {
                result.append(c);
            }
        }
      
     
        result.reverse();
      
        return result.toString();
    }
}