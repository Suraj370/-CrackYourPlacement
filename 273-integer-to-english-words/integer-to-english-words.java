class Solution {
      private static final Map<Integer, String> NUMBER_TO_WORDS_MAP;

    static {
        NUMBER_TO_WORDS_MAP = new HashMap<>();
        NUMBER_TO_WORDS_MAP.put(1, "One");
        NUMBER_TO_WORDS_MAP.put(2, "Two");
        NUMBER_TO_WORDS_MAP.put(3, "Three");
        NUMBER_TO_WORDS_MAP.put(4, "Four");
        NUMBER_TO_WORDS_MAP.put(5, "Five");
        NUMBER_TO_WORDS_MAP.put(6, "Six");
        NUMBER_TO_WORDS_MAP.put(7, "Seven");
        NUMBER_TO_WORDS_MAP.put(8, "Eight");
        NUMBER_TO_WORDS_MAP.put(9, "Nine");
        NUMBER_TO_WORDS_MAP.put(10, "Ten");
        NUMBER_TO_WORDS_MAP.put(11, "Eleven");
        NUMBER_TO_WORDS_MAP.put(12, "Twelve");
        NUMBER_TO_WORDS_MAP.put(13, "Thirteen");
        NUMBER_TO_WORDS_MAP.put(14, "Fourteen");
        NUMBER_TO_WORDS_MAP.put(15, "Fifteen");
        NUMBER_TO_WORDS_MAP.put(16, "Sixteen");
        NUMBER_TO_WORDS_MAP.put(17, "Seventeen");
        NUMBER_TO_WORDS_MAP.put(18, "Eighteen");
        NUMBER_TO_WORDS_MAP.put(19, "Nineteen");
        NUMBER_TO_WORDS_MAP.put(20, "Twenty");
        NUMBER_TO_WORDS_MAP.put(30, "Thirty");
        NUMBER_TO_WORDS_MAP.put(40, "Forty");
        NUMBER_TO_WORDS_MAP.put(50, "Fifty");
        NUMBER_TO_WORDS_MAP.put(60, "Sixty");
        NUMBER_TO_WORDS_MAP.put(70, "Seventy");
        NUMBER_TO_WORDS_MAP.put(80, "Eighty");
        NUMBER_TO_WORDS_MAP.put(90, "Ninety");
        NUMBER_TO_WORDS_MAP.put(100, "Hundred");
        NUMBER_TO_WORDS_MAP.put(1000, "Thousand");
        NUMBER_TO_WORDS_MAP.put(1000000, "Million");
        NUMBER_TO_WORDS_MAP.put(1000000000, "Billion");
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder wordsBuilder = new StringBuilder();
      
        for (int i = 1000000000; i >= 1000; i /= 1000) {
            if (num >= i) {
                wordsBuilder.append(processThreeDigits(num / i)).append(" ").append(NUMBER_TO_WORDS_MAP.get(i));
                num %= i;
            }
        }
      
        if (num > 0) {
            wordsBuilder.append(processThreeDigits(num));
        }
      
        return wordsBuilder.substring(1);
    }
    private String processThreeDigits(int num) {
        StringBuilder threeDigitsBuilder = new StringBuilder();
      
        if (num >= 100) {
            threeDigitsBuilder.append(" ")
                             .append(NUMBER_TO_WORDS_MAP.get(num / 100))
                             .append(" ")
                             .append(NUMBER_TO_WORDS_MAP.get(100));
            num %= 100;
        }
        if (num > 0) {
            if (num < 20 || num % 10 == 0) {
                threeDigitsBuilder.append(" ").append(NUMBER_TO_WORDS_MAP.get(num));
            } else {
                threeDigitsBuilder.append(" ")
                                  .append(NUMBER_TO_WORDS_MAP.get(num / 10 * 10))
                                  .append(" ")
                                  .append(NUMBER_TO_WORDS_MAP.get(num % 10));
            }
        }
        return threeDigitsBuilder.toString();
    }
}