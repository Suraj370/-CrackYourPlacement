class Solution {
    public String simplifyPath(String path) {
        final String[] dirs = path.split("/");
        Stack<String> st = new Stack<>();
        for(final String dir : dirs){
            if(dir.isEmpty() || dir.equals("."))
               continue;
            if(dir.equals("..")){
               if(!st.isEmpty())
                   st.pop();
            }
             else
                st.push(dir);
        }

        return "/" + String.join("/", st);

    }
}