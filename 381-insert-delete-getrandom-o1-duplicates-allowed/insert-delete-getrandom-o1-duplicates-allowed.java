class RandomizedCollection {

      private Map<Integer, Set<Integer>> valueToIndicesMap;
    private List<Integer> valuesList;
    private Random randomGenerator;

    public RandomizedCollection() {
        valueToIndicesMap = new HashMap<>();
        valuesList = new ArrayList<>();
        randomGenerator = new Random();
    }
    
    public boolean insert(int val) {
        valueToIndicesMap.computeIfAbsent(val, k -> new HashSet<>()).add(valuesList.size());
        valuesList.add(val);
        return valueToIndicesMap.get(val).size() == 1;
    }
    
    public boolean remove(int val) {
          if (!valueToIndicesMap.containsKey(val)) {
            return false;
        }
        Set<Integer> idxSet = valueToIndicesMap.get(val);
        int removeIndex = idxSet.iterator().next();
        int lastValueIndex = valuesList.size() - 1;

        valuesList.set(removeIndex, valuesList.get(lastValueIndex));
        idxSet.remove(removeIndex);

        Set<Integer> lastValueIndices = valueToIndicesMap.get(valuesList.get(lastValueIndex));
        lastValueIndices.remove(lastValueIndex);
        if (removeIndex < lastValueIndex) {
            lastValueIndices.add(removeIndex);
        }

        if (idxSet.isEmpty()) {
            valueToIndicesMap.remove(val);
        }

        valuesList.remove(lastValueIndex);
        return true;
    }
    
    public int getRandom() {
        int size = valuesList.size();

        return size == 0 ? -1 : valuesList.get(randomGenerator.nextInt(size));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */