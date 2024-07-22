class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for(int i =0; i < n; i++){
            while(nums[i] != nums[nums[i] - 1])
              swap(nums, i, nums[i] - 1);
        }
        List<Integer> duplicates = new ArrayList<>();
        for(int i =0; i < n; i++){
            if(nums[i] != i + 1)
                duplicates.add(nums[i]);
        }
        return duplicates;
    }
      private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}