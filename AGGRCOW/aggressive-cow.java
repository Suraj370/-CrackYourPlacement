


import java.util.*;

 class aggressiveCows {
    public static boolean isPossible(int[] stalls, int dist, int cows) {
        int n = stalls.length; 
        int cntCows = 1; 
        int last = stalls[0]; 
        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= dist) {
                cntCows++; 
                last = stalls[i]; 
            }
            if (cntCows >= cows) return true;
        }
        return false;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length; 
        Arrays.sort(stalls);

        int low = 1, high = stalls[n - 1] - stalls[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(stalls, mid, k)) {
                low = mid + 1;
            } else high = mid - 1;
        }
        return high;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
           int N = in.nextInt();
           int C = in.nextInt();
           int[] stalls = new int[N];
           for(int i =0; i < N; i++){
            stalls[i] = in.nextInt();
            int ans = aggressiveCows(stalls, C);
           }

        }
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = aggressiveCows(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans);
    }
}

