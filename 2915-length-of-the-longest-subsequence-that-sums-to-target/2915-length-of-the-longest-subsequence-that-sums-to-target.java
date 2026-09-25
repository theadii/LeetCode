class Solution {

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {

        int n = nums.size();

        int[][] dp = new int[n + 1][target + 1];

        // i == n
        Arrays.fill(dp[n], -10000);
        dp[n][0] = 0;

        for (int i = n - 1; i >= 0; i--) {

            dp[i][0] = 0;

            for (int ttl = 1; ttl <= target; ttl++) {

                int nTake = dp[i + 1][ttl];

                int take = -10000;

                if (ttl >= nums.get(i)) {
                    take = 1 + dp[i + 1][ttl - nums.get(i)];
                }

                dp[i][ttl] = Math.max(take, nTake);
            }
        }

        return dp[0][target] < 0 ? -1 : dp[0][target];
    }
}