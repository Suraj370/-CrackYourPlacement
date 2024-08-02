class Solution {
  public List<Integer> countSmaller(int[] nums) {
        Set<Integer> uniqueValues = new HashSet<>();
        for (int value : nums) {
            uniqueValues.add(value);
        }

        List<Integer> sortedUniqueValues = new ArrayList<>(uniqueValues);
        Collections.sort(sortedUniqueValues);

        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < sortedUniqueValues.size(); ++i) {
            valueToIndex.put(sortedUniqueValues.get(i), i + 1);
        }

        FenwickTree fenwickTree = new FenwickTree(sortedUniqueValues.size());

        LinkedList<Integer> result = new LinkedList<>();

        for (int i = nums.length - 1; i >= 0; --i) {
            int index = valueToIndex.get(nums[i]); 
            fenwickTree.update(index, 1);          
            result.addFirst(fenwickTree.query(index - 1)); 
        }

        return result;
    }
}


class FenwickTree {
    private int size;
    private int[] tree;

    // Constructor for Fenwick Tree with a given size
    public FenwickTree(int size) {
        this.size = size;
        this.tree = new int[size + 1];
    }

    // Update the Fenwick Tree with a given value at a specified index
    public void update(int index, int delta) {
        while (index <= size) {
            tree[index] += delta;
            index += lowBit(index);
        }
    }

    // Query the cumulative frequency from index 1 to the given index
    public int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= lowBit(index);
        }
        return sum;
    }

    // Method to get the lowest one bit value of a given number
    public static int lowBit(int x) {
        return x & (-x);
    }
}