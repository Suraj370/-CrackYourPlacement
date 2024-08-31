class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        li.add(new ArrayList<>());
        for(int n : nums){
            List<List<Integer>> ns = new ArrayList<>();
            for(List<Integer> curr: li)
                ns.add(new ArrayList<>(curr){{add(n);}});
            for(List<Integer> curr: ns)
                li.add(curr);
        }


        return li;
    }
}