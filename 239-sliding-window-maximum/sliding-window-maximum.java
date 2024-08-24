class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
         ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (i = 0; i < k; ++i) {
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
 
                dq.removeLast();
             dq.addLast(i);
        }
        // System.out.println(dq);
        for (; i < n; ++i) {
            ans.add(arr[dq.peek()]);
            // System.out.println(dq);
            while ((!dq.isEmpty()) && dq.peek() <= i - k)
                dq.removeFirst();

            while ((!dq.isEmpty()) && arr[i] >= arr[dq.peekLast()])
                dq.removeLast();
 
            dq.addLast(i);
        }
       ans.add(arr[dq.peekFirst()]);
        return ans.stream().mapToInt(p -> p).toArray();

    }
}