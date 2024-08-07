class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justifiedText = new ArrayList<>();
        int index = 0;
        int numOfWords = words.length;

        // Process all the words
        while (index < numOfWords) {
            List<String> currentLineWords = new ArrayList<>();
            currentLineWords.add(words[index]);
            int currentLineWidth = words[index].length();
            index++;

            // Try to fit as many words in the current line as possible
            while (index < numOfWords && currentLineWidth + 1 + words[index].length() <= maxWidth) {
                currentLineWidth += 1 + words[index].length();
                currentLineWords.add(words[index++]);
            }

            // If it's the last line or the line contains only one word
            if (index == numOfWords || currentLineWords.size() == 1) {
                String leftAlignedText = String.join(" ", currentLineWords);

                // Fill the remaining space on the right with spaces
                String rightPadding = " ".repeat(maxWidth - leftAlignedText.length());
                justifiedText.add(leftAlignedText + rightPadding);
                continue;
            }

            // Distribute spaces evenly amongst words
            int totalSpaces = maxWidth - (currentLineWidth - currentLineWords.size() + 1);
            int spaceWidth = totalSpaces / (currentLineWords.size() - 1);
            int extraSpacesCount = totalSpaces % (currentLineWords.size() - 1);

            StringBuilder justifiedLine = new StringBuilder();
            for (int wordIndex = 0; wordIndex < currentLineWords.size() - 1; wordIndex++) {
                justifiedLine.append(currentLineWords.get(wordIndex));

                // Append the base number of spaces
                justifiedLine.append(" ".repeat(spaceWidth));

                // Add an extra space to the leftmost gaps if needed
                if (wordIndex < extraSpacesCount) {
                    justifiedLine.append(" ");
                }
            }

            // Append the last word in the line
            justifiedLine.append(currentLineWords.get(currentLineWords.size() - 1));
            justifiedText.add(justifiedLine.toString());
        }

        return justifiedText;
    }
}