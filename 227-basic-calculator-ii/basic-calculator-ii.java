class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>(); 
        char operation = '+'; 
        int value = 0; 

        for (int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);
          
            if (Character.isDigit(currentChar)) {
                value = value * 10 + (currentChar - '0');
            }
          
            if (i == s.length() - 1 || currentChar == '+' || currentChar == '-' 
                                      || currentChar == '*' || currentChar == '/') {
              
                switch (operation) {
                    case '+':
                        stack.push(value); 
                        break;
                    case '-':
                        stack.push(-value); 
                        break;
                    case '*':
                        stack.push(stack.pop() * value);
                        break;
                    case '/':
                        stack.push(stack.pop() / value);
                        break;
                }
              
                operation = currentChar; 
                value = 0;
            }
        }
      
        int result = 0; 
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
      
        return result;
    }
}