class Solution {
    public boolean isNumber(String s) {
        int length = s.length();
        int index = 0;

        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            index++;
        }

        if (index == length) {
            return false;
        }

        if (s.charAt(index) == '.' && (index + 1 == length || s.charAt(index + 1) == 'e' ||
            s.charAt(index + 1) == 'E')) {
            return false;
        }

        int dotCount = 0; 
        int eCount = 0;   

        for (int i = index; i < length; ++i) {
            char currentChar = s.charAt(i);

            if (currentChar == '.') {
                if (eCount > 0 || dotCount > 0) {
                    return false;
                }
                dotCount++;
            } else if (currentChar == 'e' || currentChar == 'E') {
                if (eCount > 0 || i == index || i == length - 1) {
                    return false;
                }
                eCount++;
                if (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-') {
                    if (++i == length - 1) {
                        return false;
                    }
                }
            } else if (currentChar < '0' || currentChar > '9') {
                return false;
            }
        }
        return true;
    }
}