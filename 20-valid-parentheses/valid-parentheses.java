class Solution {
    public boolean isValid(String s) {
       Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') 
                stack.push(c);
            else 
                if (stack.isEmpty() || !match(stack.pop(), c)) 
                    return false;
                
            }
        
        return stack.isEmpty();
    }

     private boolean match(char leftBracket, char rightBracket) {
        return (leftBracket == '(' && rightBracket == ')') ||
               (leftBracket == '{' && rightBracket == '}') ||
               (leftBracket == '[' && rightBracket == ']');
    }
}