class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> mp = new TreeMap<>();

        for (int x : power) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        int arr[] = new int[mp.size()];
        int idx = 0;

        for (int x : mp.keySet()) {
            arr[idx++] = x;
        }

        int n = mp.size();

        long prev1 = 0; // dp[i-1]
        long prev2 = 0; // dp[i-2]
        long prev3 = 0; // dp[i-3]

        for (int i = 0; i < n; i++) {

            long now = (long) arr[i] * mp.get(arr[i]);

            if (i > 0 && arr[i] > arr[i - 1] + 2) {
                now += prev1;
            } 
            else if (i > 1 && arr[i] > arr[i - 2] + 2) {
                now += prev2;
            }
            else if (i > 2 && arr[i] > arr[i - 3] + 2) {
                now += prev3;
            }

            long curr = Math.max(prev1, now);

            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}