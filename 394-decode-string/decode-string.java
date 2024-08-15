class Solution {
     private int stringToInteger(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans *= 10;
            ans += s.charAt(i) - '0';
        }
        return ans;
    }

    public String decodeString(String s) {
         StringBuilder ans = new StringBuilder();
        int prev = 0;
        int repetitions = 0;
        int depth = 0; // keeps track of # open bracket - # close bracket
        for (int i = 0; i < s.length(); i++) {
            if (depth == 0 && 'a' <= s.charAt(i) && s.charAt(i) <= 'z') {
            	  // case with lowercase letters
                ans.append(s.charAt(i));
                prev = i + 1;
            }
            if (s.charAt(i) == '[') {
                depth++;
                if (depth == 1) { // open bracket for the case "k[s]"
                    repetitions = stringToInteger(s.substring(prev, i));
                    prev = i + 1;
                }
            } else if (s.charAt(i) == ']') {
                depth--;
                if (depth == 0) { // close bracket for the case "k[s]"
                    while (repetitions > 0) { // add k copies of s
                        ans.append(decodeString(s.substring(prev, i)));
                        repetitions--;
                    }
                    prev = i + 1;
                }
            }
        }
        return ans.toString();
    }
}