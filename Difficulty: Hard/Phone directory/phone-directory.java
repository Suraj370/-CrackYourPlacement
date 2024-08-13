//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        TreeSet<String> words;
        
        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
            words = new TreeSet<>();
        }
    }
    
    static TrieNode root;
    
    static void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
            current.words.add(word);
        }
        current.isEndOfWord = true;
    }
    
    static ArrayList<String> search(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return new ArrayList<>();
            }
            current = current.children[index];
        }
        return new ArrayList<>(current.words);
    }
    
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s) {
        root = new TrieNode();
        
        // Insert all contacts into the Trie
        for (String word : contact) {
            insert(word);
        }
        
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        // Search for each prefix of s
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            ArrayList<String> matches = search(prefix);
            
            if (matches.isEmpty()) {
                matches.add("0");
            }
            
            result.add(matches);
        }
        
        return result;
    }
}