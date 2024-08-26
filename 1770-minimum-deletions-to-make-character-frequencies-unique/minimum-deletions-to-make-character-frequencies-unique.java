class Solution {
     public int minDeletions(String s) {
        int[] characterFrequency = new int[26];
      
        for (int i = 0; i < s.length(); ++i) {
            characterFrequency[s.charAt(i) - 'a']++;
        }
      
        Arrays.sort(characterFrequency);
      
        int totalDeletions = 0;
        int previousFrequency = Integer.MAX_VALUE;
      
        for (int i = 25; i >= 0; --i) {
            int currentFrequency = characterFrequency[i];
          
            if (previousFrequency == 0) {
                totalDeletions += currentFrequency;
            } else if (currentFrequency >= previousFrequency) {
   
                totalDeletions += currentFrequency - previousFrequency + 1;
                previousFrequency--;
            } else {
                previousFrequency = currentFrequency;
            }
        }
      
        return totalDeletions;
    }
}