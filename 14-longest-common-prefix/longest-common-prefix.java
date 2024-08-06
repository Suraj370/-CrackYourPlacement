class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if(strs.length == 0 || strs == null)return result.toString();
        int i = 0;
        while(true){
            if(i >= strs[0].length())return result.toString();
            char commonChar = strs[0].charAt(i);
            for(String str : strs){
                if(i >= str.length() || commonChar != str.charAt(i))return result.toString();
            }
            result.append(commonChar);
            ++i;
        }
    }
}