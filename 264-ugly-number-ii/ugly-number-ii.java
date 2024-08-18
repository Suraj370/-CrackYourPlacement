class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;

        int index2 = 0, index3 = 0, index5 = 0;

        for (int i = 1; i < n; ++i) {
            int nextMultipleOf2 = uglyNumbers[index2] * 2;
            int nextMultipleOf3 = uglyNumbers[index3] * 3;
            int nextMultipleOf5 = uglyNumbers[index5] * 5;

            uglyNumbers[i] = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));

            if (uglyNumbers[i] == nextMultipleOf2) {
                index2++;
            }
            if (uglyNumbers[i] == nextMultipleOf3) {
                index3++;
            }
            if (uglyNumbers[i] == nextMultipleOf5) {
                index5++;
            }
        }

        return uglyNumbers[n - 1];
    }
}