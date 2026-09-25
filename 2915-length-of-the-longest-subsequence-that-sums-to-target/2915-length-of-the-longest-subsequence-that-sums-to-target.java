class Solution {
    int dp[][];
    int solve(int i,int ttl,List<Integer> nums){
        if(ttl == 0){
            return 0;
        }

        if(i == nums.size() || ttl<0 ){
        
            return Integer.MIN_VALUE;
        }
        if(dp[i][ttl]!=-1) return dp[i][ttl];

        
        
        int take = 1 + solve(i+1,ttl - nums.get(i),nums);
        
        int nTake = solve(i+1,ttl,nums);

        return dp[i][ttl]= Math.max(take,nTake);

    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        dp = new int[n+1][target+1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans  = solve(0,target,nums);
        return ans < 0 ? -1 : ans ;
    }
}