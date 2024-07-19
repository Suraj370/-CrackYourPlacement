class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 0) return  0;
        int len = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] != nums[len -1]){
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}